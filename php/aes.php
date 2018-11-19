<?
header('Content-Type: application/json');

$plain = "SOME-DATA-TO-BLOCK-ENCRYPTION";
$key = "SOME-ENCRYPTION-KEY-USED-ONLY-16-OR-32-BYTES";
$iv = "SOME-INITIAL-VECTOR-USED-ONLY-16-BYTES";
$ivFixed = substr($iv, 0, 16);

echo "plain::$plain\n";
echo "key::$key\n";
echo "iv::$iv\n";
echo "key hex 128::".hex($key, 16)."\n";
echo "key hex 256::".hex($key, 32)."\n";
echo "iv  hex 128::".hex($iv, 16)."\n";

$aesEncrypted128 = aesEncrypt($plain, $key, $iv, 128);
echo "aesEncrypted128::$aesEncrypted128\n";
$aesEncrypted256 = aesEncrypt($plain, $key, $iv, 256);
echo "aesEncrypted256::$aesEncrypted256\n";
$aesDecrypted128 = aesDecrypt($aesEncrypted128, $key, $iv, 128);
echo "aesDecrypted128::$aesDecrypted128\n";
$aesDecrypted256 = aesDecrypt($aesEncrypted256, $key, $iv, 256);
echo "aesDecrypted256::$aesDecrypted256\n";

function hex($str, $maxLength) {
    return bin2hex(substr($str, 0, $maxLength));
}

function fixIv($ivIn) {
	$ivOut = null;
	if (!is_null($ivIn)) {
		if (strlen($ivIn) < 16) {
			$ivOut = str_pad($ivIn, 16, '\0');
		} else {
			$ivOut = substr($ivIn, 0, 16);
		}
	} else {
		$ivOut = str_pad("", 16, '\0');
	}

	return $ivOut;
}

function aesEncrypt($data, $secret_key, $secret_iv, $cipherBit) {
	$cipher = "aes-$cipherBit-cbc";
	$encrypted = openssl_encrypt($data, $cipher, $secret_key, OPENSSL_RAW_DATA, fixIv($secret_iv));
	return base64_encode($encrypted);
}

function aesDecrypt($data, $secret_key, $secret_iv, $cipherBit) {
	$cipher = "aes-$cipherBit-cbc";
    $b64Decoded = base64_decode($data);

    return openssl_decrypt($b64Decoded, $cipher, $secret_key, OPENSSL_RAW_DATA, fixIv($secret_iv));
}
?>

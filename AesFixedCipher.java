package test.aes;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesFixedCipher {
  
  private static final String CIPHER_INSTANCE_TYPE = "AES/CBC/PKCS5Padding";
  private static final String SECRET_KEY_ALGORITHM = "AES";
  private static final String DEFAULT_ENCODING = "UTF-8";
  
  private Cipher ciperEncryptMode = null;
  private Cipher ciperDecryptMode = null;
  
  private AesFixedCipher() {}
  public AesFixedCipher(String key, String iv, int keyBlockSizeBit)
      throws
        NoSuchAlgorithmException, NoSuchPaddingException,
        UnsupportedEncodingException, InvalidKeyException,
        InvalidAlgorithmParameterException,
        IllegalBlockSizeException, BadPaddingException
  {
    this();
    ciperEncryptMode = getCipher(Cipher.ENCRYPT_MODE, key, iv, keyBlockSizeBit);
    ciperDecryptMode = getCipher(Cipher.DECRYPT_MODE, key, iv, keyBlockSizeBit);
  }
  
  private Cipher getCipher(int opMode, String key, String iv, int keyBlockSizeBit)
      throws
        NoSuchAlgorithmException, NoSuchPaddingException,
        UnsupportedEncodingException, InvalidKeyException,
        InvalidAlgorithmParameterException,
        IllegalBlockSizeException, BadPaddingException
  {
    Cipher ciper = Cipher.getInstance(CIPHER_INSTANCE_TYPE);
    byte[] ivBytes = string2SizedBytes(iv, ciper.getBlockSize());
    byte[] keyBytes = string2SizedBytes(key, keyBlockSizeBit/8);
    
    SecretKeySpec keySpec = new SecretKeySpec(keyBytes,SECRET_KEY_ALGORITHM);
    IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

    ciper.init(opMode, keySpec, ivSpec);
    
    return ciper;
  }

  public String encrypt(byte[] data)
      throws
      IllegalBlockSizeException, BadPaddingException
  {
    try {
      byte[] encrypted = null;
      synchronized (ciperEncryptMode) {
        encrypted = ciperEncryptMode.doFinal(data);
      }
      return Base64.getEncoder().encodeToString(encrypted);
    } catch (IllegalBlockSizeException
        | BadPaddingException
        e) {
      throw e;
    }
  }

  public String decrypt(String input)
      throws
        IllegalBlockSizeException, BadPaddingException
  {
    try {
      byte[] data  = Base64.getDecoder().decode(input);
      byte[] decrypted = null;
      synchronized (ciperDecryptMode) {
        decrypted = ciperDecryptMode.doFinal(data);
      }
      return new String(decrypted);
    } catch (IllegalBlockSizeException
        | BadPaddingException
        e) {
      throw e;
    }
  }

  private static byte[] string2SizedBytes(String in, int size) throws UnsupportedEncodingException {
    byte[] bytesIn = in.getBytes(DEFAULT_ENCODING);
    byte[] out = new byte[size];
    int maxLen = bytesIn.length > size ? size : bytesIn.length;
    System.arraycopy(bytesIn, 0, out, 0, maxLen);
    return out;
  }

}

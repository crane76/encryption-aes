
# AES encryption JAVA Implementation

# Result of AesUtilTest
<pre><code>
plain::SOME-DATA-TO-BLOCK-ENCRYPTION
key::SOME-ENCRYPTION-KEY-USED-ONLY-16-OR-32-BYTES
iv::SOME-INITIAL-VECTOR-USED-ONLY-16-BYTES
iv::U09NRS1JTklUSUFMLVZFQ1RPUi1VU0VELU9OTFktMTYtQllURVM=
key hex 128::534f4d452d454e4352595054494f4e2d
key hex 256::534f4d452d454e4352595054494f4e2d4b45592d555345442d4f4e4c592d3136
iv  hex 128::534f4d452d494e495449414c2d564543
aesEncrypted128::3Usa7qwKQKXFnZqQXUG6EhMa02OkEhCRdtsE4Q+aui4=
aesEncrypted256::oKz6SUJuAk/GPXuXCKBQf13nFGCRLi3TMEt7vytfg+k=
aesDecrypted128::SOME-DATA-TO-BLOCK-ENCRYPTION
aesDecrypted256::SOME-DATA-TO-BLOCK-ENCRYPTION
</code></pre>

# Result of AesPerformanceTest
<pre><code>
============================ AesUtil
aesEncryption 128::578
aesEncryption 256::459
aesDecryption 128::354
aesDecryption 256::350
============================ FixedAes
aesEncryption 128::32
aesEncryption 256::29
aesDecryption 128::26
aesDecryption 256::23
============================ AesUtil
aesEncryption 128::279
aesEncryption 256::345
aesDecryption 128::359
aesDecryption 256::310
============================ FixedAes
aesEncryption 128::26
aesEncryption 256::27
aesDecryption 128::25
aesDecryption 256::23
============================ AesUtil
aesEncryption 128::260
aesEncryption 256::286
aesDecryption 128::251
aesDecryption 256::280
============================ FixedAes
aesEncryption 128::25
aesEncryption 256::39
aesDecryption 128::30
aesDecryption 256::32
============================ AesUtil
aesEncryption 128::317
aesEncryption 256::279
aesDecryption 128::257
aesDecryption 256::278
============================ FixedAes
aesEncryption 128::25
aesEncryption 256::26
aesDecryption 128::25
aesDecryption 256::27
============================ AesUtil
aesEncryption 128::257
aesEncryption 256::284
aesDecryption 128::272
aesDecryption 256::272
============================ FixedAes
aesEncryption 128::24
aesEncryption 256::25
aesDecryption 128::21
aesDecryption 256::21
============================ AesUtil
aesEncryption 128::260
aesEncryption 256::286
aesDecryption 128::255
aesDecryption 256::275
============================ FixedAes
aesEncryption 128::23
aesEncryption 256::26
aesDecryption 128::21
aesDecryption 256::22
============================ AesUtil
aesEncryption 128::294
aesEncryption 256::304
aesDecryption 128::255
aesDecryption 256::279
============================ FixedAes
aesEncryption 128::23
aesEncryption 256::26
aesDecryption 128::21
aesDecryption 256::24
============================ FixedAes
aesEncryption 128::23
aesEncryption 256::26
aesDecryption 128::21
aesDecryption 256::22
============================ AesUtil
aesEncryption 128::256
aesEncryption 256::281
aesDecryption 128::267
aesDecryption 256::274
</code></pre>

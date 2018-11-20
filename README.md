# encryption-aes
encrypt/decrypt aes in java, php and check in openssl

# encryption info
<pre><code>
plain::SOME-DATA-TO-BLOCK-ENCRYPTION
key::SOME-ENCRYPTION-KEY-USED-ONLY-16-OR-32-BYTES
iv::SOME-INITIAL-VECTOR-USED-ONLY-16-BYTES
key hex 128::534f4d452d454e4352595054494f4e2d
key hex 256::534f4d452d454e4352595054494f4e2d4b45592d555345442d4f4e4c592d3136
iv  hex 128::534f4d452d494e495449414c2d564543
</code></pre>

# openssl encryption and decryption test
<pre><code>
user@server:~ % echo -n "SOME-DATA-TO-BLOCK-ENCRYPTION" | openssl enc -aes-128-cbc -base64 -K 534f4d452d454e4352595054494f4e2d -iv 534f4d452d494e495449414c2d564543
3Usa7qwKQKXFnZqQXUG6EhMa02OkEhCRdtsE4Q+aui4=
user@server:~ % echo -n "SOME-DATA-TO-BLOCK-ENCRYPTION" | openssl enc -aes-256-cbc -base64 -K 534f4d452d454e4352595054494f4e2d4b45592d555345442d4f4e4c592d3136 -iv 534f4d452d494e495449414c2d564543
oKz6SUJuAk/GPXuXCKBQf13nFGCRLi3TMEt7vytfg+k=

user@server:~ % echo 3Usa7qwKQKXFnZqQXUG6EhMa02OkEhCRdtsE4Q+aui4= | openssl enc -aes-128-cbc -d -a -K 534f4d452d454e4352595054494f4e2d -iv 534f4d452d494e495449414c2d564543 ; echo
SOME-DATA-TO-BLOCK-ENCRYPTION
user@server:~ % echo oKz6SUJuAk/GPXuXCKBQf13nFGCRLi3TMEt7vytfg+k= | openssl enc -aes-256-cbc -d -a -K 534f4d452d454e4352595054494f4e2d4b45592d555345442d4f4e4c592d3136 -iv 534f4d452d494e495449414c2d564543 ; echo
SOME-DATA-TO-BLOCK-ENCRYPTION
</code></pre>

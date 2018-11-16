package util;

import java.util.Base64;

public class AesUtilTest {
  public static void main(String[] args) {
    String plain = "SOME-DATA-TO-BLOCK-ENCRYPTION11111111111";
    String key = "SOME-ENCRYPTION-KEY-USED-ONLY-16-OR-32-BYTES";
    String iv = "SOME-INITIAL-VECTOR-USED-ONLY-16-BYTES";
    
    try {
      System.out.println("plain::"+plain);
      System.out.println("key::"+key);
      System.out.println("iv::"+iv);
      System.out.println("iv::"+Base64.getEncoder().encodeToString(iv.getBytes("UTF-8")));
      

      System.out.println("key hex 128::"+asciiToHex(key, 16));
      System.out.println("key hex 256::"+asciiToHex(key, 32));
      System.out.println("iv  hex 128::"+asciiToHex(iv, 16));
      
      byte[] data = plain.getBytes("UTF-8");
      String aesEncrypted128 = AesUtil.encrypt(data, key, iv, 128);
      String aesEncrypted256 = AesUtil.encrypt(data, key, iv, 256);

      System.out.println("aesEncrypted128::"+aesEncrypted128);
      System.out.println("aesEncrypted256::"+aesEncrypted256);
      
      
      String aesDecrypted128 = AesUtil.decrypt(aesEncrypted128, key, iv, 128);
      String aesDecrypted256 = AesUtil.decrypt(aesEncrypted256, key, iv, 256);

      System.out.println("aesDecrypted128::"+aesDecrypted128);
      System.out.println("aesDecrypted256::"+aesDecrypted256);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static String asciiToHex(String asciiStr, int maxBytes) {
    char[] chars = asciiStr.toCharArray();
    StringBuilder hex = new StringBuilder();
    int i = 0;
    for (char ch : chars) {
        hex.append(Integer.toHexString((int) ch));
        i++;
        if (maxBytes > 0 && i >= maxBytes) {
          break;
        }
    }
 
    return hex.toString();
  }
}

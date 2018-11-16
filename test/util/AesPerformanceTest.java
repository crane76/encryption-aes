package util;

public class AesPerformanceTest {
  public static void main(String[] args) {
    String plain = "SOME-DATA-TO-BLOCK-ENCRYPTION11111111111";
    String key = "SOME-ENCRYPTION-KEY-USED-ONLY-16-OR-32-BYTES";
    String iv = "SOME-INITIAL-VECTOR-USED-ONLY-16-BYTES";
    
    try {
      testPerformances(key, iv, plain);
      testPerformancesFixedCiher(key, iv, plain);
      testPerformances(key, iv, plain);
      testPerformancesFixedCiher(key, iv, plain);
      testPerformances(key, iv, plain);
      testPerformancesFixedCiher(key, iv, plain);
      testPerformances(key, iv, plain);
      testPerformancesFixedCiher(key, iv, plain);
      testPerformances(key, iv, plain);
      testPerformancesFixedCiher(key, iv, plain);
      testPerformances(key, iv, plain);
      testPerformancesFixedCiher(key, iv, plain);
      testPerformances(key, iv, plain);
      testPerformancesFixedCiher(key, iv, plain);
      testPerformancesFixedCiher(key, iv, plain);
      testPerformances(key, iv, plain);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void testPerformances(String key, String iv, String data) throws Exception {

    int loops = 50000;
    long s, e;
    
    String[] aesEncrypted128 = new String[loops];
    String[] aesEncrypted256 = new String[loops];
    
    System.out.println("============================ AesUtil");
    
    s = System.currentTimeMillis();
    for (int i = 0; i < loops; i++) {
      aesEncrypted128[i] = AesUtil.encrypt((i+data+i).getBytes("UTF-8"), key, iv, 128);
    }
    e = System.currentTimeMillis();
    System.out.println("aesEncryption 128::"+(e-s));
    
    s = System.currentTimeMillis();
    for (int i = 0; i < loops; i++) {
      aesEncrypted256[i] = AesUtil.encrypt((i+data+i).getBytes("UTF-8"), key, iv, 256);
    }
    e = System.currentTimeMillis();
    System.out.println("aesEncryption 256::"+(e-s));
    

    s = System.currentTimeMillis();
    for (int i = 0; i < loops; i++) {
      AesUtil.decrypt(aesEncrypted128[i], key, iv, 128);
    }
    e = System.currentTimeMillis();
    System.out.println("aesDecryption 128::"+(e-s));
    
    s = System.currentTimeMillis();
    for (int i = 0; i < loops; i++) {
      AesUtil.decrypt(aesEncrypted256[i], key, iv, 256);
    }
    e = System.currentTimeMillis();
    System.out.println("aesDecryption 256::"+(e-s));
  }
  
  public static void testPerformancesFixedCiher(String key, String iv, String data) throws Exception {

    int loops = 50000;
    long s, e;
    
    AesFixedCipher cipher128 = new AesFixedCipher(key, iv, 128);
    AesFixedCipher cipher256 = new AesFixedCipher(key, iv, 256);
    
    String[] aesEncrypted128 = new String[loops];
    String[] aesEncrypted256 = new String[loops];
    
    System.out.println("============================ FixedAes");
    
    s = System.currentTimeMillis();
    for (int i = 0; i < loops; i++) {
      aesEncrypted128[i] = cipher128.encrypt((i+data+i).getBytes("UTF-8"));
    }
    e = System.currentTimeMillis();
    System.out.println("aesEncryption 128::"+(e-s));
    
    s = System.currentTimeMillis();
    for (int i = 0; i < loops; i++) {
      aesEncrypted256[i] = cipher256.encrypt((i+data+i).getBytes("UTF-8"));
    }
    e = System.currentTimeMillis();
    System.out.println("aesEncryption 256::"+(e-s));
    

    s = System.currentTimeMillis();
    for (int i = 0; i < loops; i++) {
      cipher128.decrypt(aesEncrypted128[i]);
    }
    e = System.currentTimeMillis();
    System.out.println("aesDecryption 128::"+(e-s));
    
    s = System.currentTimeMillis();
    for (int i = 0; i < loops; i++) {
      cipher256.decrypt(aesEncrypted256[i]);
    }
    e = System.currentTimeMillis();
    System.out.println("aesDecryption 256::"+(e-s));
  }
}

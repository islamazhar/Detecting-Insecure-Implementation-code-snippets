package examples.AllCodeSnippets; 
public class class_1138{ 
 public static void main() { 
 private static byte[] getRawKey(byte[] seed) throws Exception {
    KeyGenerator kgen = KeyGenerator.getInstance("AES");
    SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
    // this is wrong!
    sr.setSeed(seed);
    kgen.init(128, sr); // 192 and 256 bits may not be available
    SecretKey skey = kgen.generateKey();
    byte[] raw = skey.getEncoded();
    return raw;
}
  }
}

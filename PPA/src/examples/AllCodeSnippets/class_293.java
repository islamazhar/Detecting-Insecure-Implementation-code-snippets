package examples.AllCodeSnippets; 
public class class_293{ 
 public static void main() { 
public SecretKey newAESKey() {

    try {
        String s_key = new BigInteger(130, random).toString(32);

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

        sr.setSeed(s_key.getBytes());
        kgen.init(128, sr); // 192 and 256 bits may not be available

        SecretKey skey = kgen.generateKey();
        return skey;
    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}
  }
}

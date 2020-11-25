package examples.AllCodeSnippets; 
public class class_479{ 
 public static void main() { 
SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
    sr.setSeed(seed);
    kgen.init(128, sr); // 192 and 256 bits may not be available
    SecretKey skey = kgen.generateKey();
  }
}

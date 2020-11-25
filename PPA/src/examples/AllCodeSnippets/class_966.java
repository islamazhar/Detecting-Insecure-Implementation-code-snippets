package examples.AllCodeSnippets; 
public class class_966{ 
 public static void main() { 
KeyGenerator keygen = KeyGenerator.getInstance("AES");
SecureRandom secrand = SecureRandom.getInstance("SHA1PRNG");
secrand.setSeed(seed.getBytes());
keygen.init(128, secrand);
SecretKey seckey = keygen.generateKey();
byte[] rawKey = seckey.getEncoded();
  }
}

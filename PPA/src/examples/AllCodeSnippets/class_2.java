package examples.AllCodeSnippets; 
public class class_2{ 
 public static void main() { 
public static SecretKey generateKey(char[] passphraseOrPin, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
// Number of PBKDF2 hardening rounds to use. Larger values increase
// computation time. You should select a value that causes computation
// to take >100ms.
final int iterations = 8000; 

// Generate a 160-bit key
final int outputKeyLength = 160;

SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
KeySpec keySpec = new PBEKeySpec(passphraseOrPin, salt, iterations, outputKeyLength);
SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);
return secretKey;
  }
}

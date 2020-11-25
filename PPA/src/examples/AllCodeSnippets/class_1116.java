package examples.AllCodeSnippets; 
public class class_1116{ 
 public static void main() { 
ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
byte[] iv = new byte[IV_LENGTH];
SecureRandom random = new SecureRandom();
random.nextBytes(iv);
ecipher.init(Cipher.ENCRYPT_MODE, secret, new IvParameterSpec(iv));
byte[] enc = ecipher.doFinal(utf8);
  }
}

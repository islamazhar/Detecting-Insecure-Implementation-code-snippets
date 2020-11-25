package examples.AllCodeSnippets; 
public class class_1147{ 
 public static void main() { 
SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.ENCRYPT_MODE, keySpec);
byte[] encrypted = cipher.doFinal(clearTextBytes);
  }
}

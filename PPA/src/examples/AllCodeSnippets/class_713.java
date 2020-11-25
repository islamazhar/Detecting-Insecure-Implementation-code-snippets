package examples.AllCodeSnippets; 
public class class_713{ 
 public static void main() { 
byte[] keyBytes = KeyGenerator.getInstance("AES").getEncoded();

...

SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "AES");
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.DECRYPT_MODE, skeySpec);
  }
}

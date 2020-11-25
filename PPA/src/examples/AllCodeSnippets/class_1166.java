package examples.AllCodeSnippets; 
public class class_1166{ 
 public static void main() { 
Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING"); 
cipher.init(Cipher.ENCRYPT_MODE, key); 
String encryptedText = Base64.encodeToString(cipher.doFinal(message), Base64.DEFAULT);
  }
}

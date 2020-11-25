package examples.AllCodeSnippets; 
public class class_930{ 
 public static void main() { 
Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // adjust padding
cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(...));
  }
}

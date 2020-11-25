package examples.AllCodeSnippets; 
public class class_1270{ 
 public static void main() { 
cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv)); 
ciphertext = cipher.doFinal(imageByte);
  }
}

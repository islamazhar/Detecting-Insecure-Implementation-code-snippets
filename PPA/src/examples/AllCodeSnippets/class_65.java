package examples.AllCodeSnippets; 
public class class_65{ 
 public static void main() { 
private InputStream getDecodedInputStream (InputStream eis) {
   Cipher cipher = Cipher.getInstance("your cipher definition");
   cipher.init(Cipher.DECRYPT_MODE, "your keySpec", new IvParameterSpec("your IV parameter spec"));
   InputStream decryptedInputStream = new CipherInputStream(is, cipher);
   return decryptedInputStream;
}
  }
}

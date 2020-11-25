package examples.AllCodeSnippets; 
public class class_302{ 
 public static void main() { 
 public byte[] keyGen() throws NoSuchAlgorithmException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    keyGenerator.init(192);
    return keyGenerator.generateKey().getEncoded();
 }
  }
}

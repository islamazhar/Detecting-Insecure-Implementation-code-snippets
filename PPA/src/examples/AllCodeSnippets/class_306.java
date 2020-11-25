package examples.AllCodeSnippets; 
public class class_306{ 
 public static void main() { 
public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(2048);
    KeyPair keyPair = keyPairGenerator.genKeyPair();
    return keyPair;
}
  }
}

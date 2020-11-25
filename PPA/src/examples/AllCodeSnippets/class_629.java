package examples.AllCodeSnippets; 
public class class_629{ 
 public static void main() { 
KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DH");
keyGen.initialize(new DHParameterSpec(p, g, l));
KeyPair ackp = keyGen.generateKeyPair();
  }
}

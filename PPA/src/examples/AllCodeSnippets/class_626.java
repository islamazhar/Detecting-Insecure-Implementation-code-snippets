package examples.AllCodeSnippets; 
public class class_626{ 
 public static void main() { 
KeyPairGenerator keyGen = null;
KeyPair kp = null;

keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");

ECGenParameterSpec ecSpec = new ECGenParameterSpec("brainpoolp160r1");
keyGen.initialize(ecSpec, new SecureRandom());

kp = keyGen.generateKeyPair();
  }
}

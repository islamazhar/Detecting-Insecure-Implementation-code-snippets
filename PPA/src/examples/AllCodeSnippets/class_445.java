package examples.AllCodeSnippets; 
public class class_445{ 
 public static void main() { 
ECGenParameterSpec ecGenSpec = new ECGenParameterSpec("prime192v1");
//using spongycastle provider
KeyPairGenerator  g = KeyPairGenerator.getInstance("ECDSA", "SC");

g.initialize(ecGenSpec, new SecureRandom());

KeyPair pair = g.generateKeyPair();
  }
}

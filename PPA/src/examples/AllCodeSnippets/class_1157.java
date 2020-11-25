package examples.AllCodeSnippets; 
public class class_1157{ 
 public static void main() { 
kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(1024);
        KeyPair kp = kpg.genKeyPair();
        publicKey = kp.getPublic();
        privateKey = kp.getPrivate();
  }
}

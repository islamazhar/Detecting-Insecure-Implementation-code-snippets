package examples.AllCodeSnippets; 
public class class_181{ 
 public static void main() { 
    PEMWriter writer = new PEMWriter(new FileWriter("test.pem"));
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(3072);
    KeyPair keyPair = kpg.generateKeyPair();
    writer.writeObject(keyPair.getPublic());
    writer.close();
  }
}
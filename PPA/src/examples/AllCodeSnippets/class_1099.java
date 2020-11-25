package examples.AllCodeSnippets; 
public class class_1099{ 
 public static void main() { 
        PEMParser pemParser = new PEMParser(new StringReader(publicKey));
        SubjectPublicKeyInfo spki = (SubjectPublicKeyInfo) pemParser.readObject();
        pemParser.close();
        byte [] spkiEncoded = spki.getEncoded();
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(spkiEncoded);

        KeyFactory kf = KeyFactory.getInstance("RSA");
        this.publicKey = kf.generatePublic(keySpec);
  }
}

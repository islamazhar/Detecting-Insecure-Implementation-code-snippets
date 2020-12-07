package examples.RSA; 
public class class_1100 { 
        PEMParser pemParser = new PEMParser(new StringReader(publicKey));
        SubjectPublicKeyInfo spki = (SubjectPublicKeyInfo) pemParser.readObject();
        pemParser.close();
        byte [] spkiEncoded = spki.getEncoded();
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(spkiEncoded);

        KeyFactory kf = KeyFactory.getInstance("RSA");
        this.publicKey = kf.generatePublic(keySpec);

}
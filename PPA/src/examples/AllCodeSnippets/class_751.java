package examples.AllCodeSnippets; 
public class class_751{ 
 public static void main() { 
public void generateKeys(){
        try {
     SharedPreferences SP;
     SharedPreferences.Editor SPE;
     KeyPairGenerator generator;
                generator = KeyPairGenerator.getInstance("RSA", "BC");
                generator.initialize(256, new SecureRandom());
                KeyPair pair = generator.generateKeyPair();
                pubKey = pair.getPublic();
                privKey = pair.getPrivate();            
                byte[] publicKeyBytes = pubKey.getEncoded();
                String pubKeyStr = new String(Base64.encode(publicKeyBytes));
                byte[] privKeyBytes = privKey.getEncoded();
                String privKeyStr = new String(Base64.encode(privKeyBytes));            
                SPE = SP.edit();
                SPE.putString("PublicKey", pubKeyStr);
                SPE.putString("PrivateKey", privKeyStr);           
                SPE.commit();

  } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }           
    }

public PublicKey getPublicKey(){
        String pubKeyStr = SP.getString("PublicKey", ");       
        byte[] sigBytes = Base64.decode(pubKeyStr);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(sigBytes);
        KeyFactory keyFact = null;
        try {
            keyFact = KeyFactory.getInstance("RSA", "BC");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        try {
            return  keyFact.generatePublic(x509KeySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getPublicKeyAsString(){
        return SP.getString("PublicKey", ");       
    }
    public PrivateKey getPrivateKey(){
        String privKeyStr = SP.getString("PrivateKey", ");
        byte[] sigBytes = Base64.decode(privKeyStr);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(sigBytes);
        KeyFactory keyFact = null;
        try {
            keyFact = KeyFactory.getInstance("RSA", "BC");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        try {
            return  keyFact.generatePrivate(x509KeySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getPrivateKeyAsString(){
        return SP.getString("PrivateKey", ");      
    }
  }
}

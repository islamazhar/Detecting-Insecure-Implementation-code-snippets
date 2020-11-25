package examples.AllCodeSnippets; 
public class class_1066{ 
 public static void main() { 
    KeyPair keys = null;
    try {
        RSAKeyGenParameterSpec spec = new RSAKeyGenParameterSpec(1024, RSAKeyGenParameterSpec.F4);
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(spec);
        keys = keyGen.generateKeyPair();
    } catch (InvalidAlgorithmParameterException e) {
        e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }

    if(keys != null){
        PublicKey mPublicKey = (PublicKey) keys.getPublic();
        PrivateKey mPrivateKey = (PrivateKey) keys.getPrivate();
    }
  }
}

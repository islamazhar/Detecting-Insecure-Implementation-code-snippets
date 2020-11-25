package examples.AllCodeSnippets; 
public class class_338{ 
 public static void main() { 
ks = KeyStore.getInstance("AndroidKeyStore");
ks.load(null);
KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry)ks.getEntry("Keys", null);
publicKey = (RSAPublicKey) keyEntry.getCertificate().getPublicKey();
  }
}

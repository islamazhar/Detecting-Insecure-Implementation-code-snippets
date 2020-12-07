package examples.RSA; 
public class class_339 { 
ks = KeyStore.getInstance("AndroidKeyStore");
ks.load(null);
KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry)ks.getEntry("Keys", null);
publicKey = (RSAPublicKey) keyEntry.getCertificate().getPublicKey();

}
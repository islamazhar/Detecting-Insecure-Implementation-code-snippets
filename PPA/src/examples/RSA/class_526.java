package examples.RSA; 
public class class_526 { 
KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) entry;

Cipher output = Cipher.getInstance("RSA/ECB/PKCS1Padding");
output.init(Cipher.DECRYPT_MODE, privateKeyEntry.getPrivateKey());

}
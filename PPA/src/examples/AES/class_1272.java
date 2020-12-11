package examples.AES; 
public class class_1272 { 
   KeyStore ks = KeyStore.getInstance();
 // get the names of all keys created by our app
 String[] keyNames = ks.saw("");

 // store a symmetric key in the keystore
 SecretKey key = Crypto.generateKey();
 boolean success = ks.put("secretKey1", key.getEncoded());
 // check if operation succeeded and get error code if not
 if (!success) {
    int errorCode = ks.getLastError();
    throw new RuntimeException("Keystore error: " + errorCode); 
 }

 // get a key from the keystore
 byte[] keyBytes = ks.get("secretKey1");
 SecretKey key = new SecretKeySpec(keyBytes, "AES");

 // delete a key
 boolean success = ks.delete("secretKey1");

}
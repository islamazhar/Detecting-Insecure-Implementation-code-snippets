package examples.AES; 
public class class_303 { 
 public byte[] keyGen() throws NoSuchAlgorithmException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    keyGenerator.init(192);
    return keyGenerator.generateKey().getEncoded();
 }

}
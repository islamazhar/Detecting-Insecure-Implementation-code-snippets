package examples.AES; 
public class class_714 { 
byte[] keyBytes = KeyGenerator.getInstance("AES").getEncoded();

...

SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "AES");
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.DECRYPT_MODE, skeySpec);

}
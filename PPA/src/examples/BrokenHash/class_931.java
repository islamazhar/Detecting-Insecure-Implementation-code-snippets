package examples.AES; 
public class class_931 { 
Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // adjust padding
cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(...));

}
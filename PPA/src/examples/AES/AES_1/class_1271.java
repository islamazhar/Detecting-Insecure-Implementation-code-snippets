package examples.AESALL; 
public class class_1271{ 
cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv)); 
ciphertext = cipher.doFinal(imageByte);

}
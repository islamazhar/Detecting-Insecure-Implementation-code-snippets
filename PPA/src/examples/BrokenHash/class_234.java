package examples.AES; 
public class class_234 { 
byte[] key = CipherUtils.getKey(password, null);
byte[] IV = CipherUtils.getIV(password, null);
Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"),
        new IvParameterSpec(IV));
cis = new CipherInputStream(is, cipher);

}
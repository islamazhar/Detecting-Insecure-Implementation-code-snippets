package examples.AESALL; 
public class class_772{ 
// convert key to bytes
byte[] keyBytes = key.getBytes("UTF-8");
// Use the first 16 bytes (or even less if key is shorter)
byte[] keyBytes16 = new byte[16];
System.arraycopy(keyBytes, 0, keyBytes16, 0, Math.min(keyBytes.length, 16));

// convert plain text to bytes
byte[] plainBytes = plainText.getBytes("UTF-8");

// setup cipher
SecretKeySpec skeySpec = new SecretKeySpec(keyBytes16, "AES");
Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
byte[] iv = new byte[16]; // initialization vector with all 0
cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(iv));

// encrypt
byte[] encrypted = cipher.doFinal(plainBytes);

}
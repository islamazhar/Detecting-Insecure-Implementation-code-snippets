package examples.AllCodeSnippets; 
public class class_1018{ 
 public static void main() { 
public static byte[] encryptAES(byte[] key, byte[] inputValue)
        throws NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
    SecretKeySpec sKeyS = new SecretKeySpec(key, "AES");

    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, sKeyS);

    return cipher.doFinal(inputValue);
}

public static byte[] decryptAES(byte[] key, byte[] encryptedData)
        throws NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
    SecretKeySpec sKeyS = new SecretKeySpec(key, "AES");

    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, sKeyS);

    return cipher.doFinal(encryptedData);
}
  }
}

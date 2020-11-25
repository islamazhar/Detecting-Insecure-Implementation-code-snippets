package examples.AllCodeSnippets; 
public class class_1255{ 
 public static void main() { 
public static String decrypt(String key, String value)throws java.io.UnsupportedEncodingException,
        NoSuchAlgorithmException,
        NoSuchPaddingException,
        InvalidKeyException,
        InvalidAlgorithmParameterException,
        IllegalBlockSizeException,
        BadPaddingException {

    byte[] keyBytes = key.getBytes("UTF-8");
    AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
    SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
    byte[] decodedVal = Base64.decode(value.getBytes("UTF-8"), Base64.DEFAULT);
    byte[] cipherData = cipher.doFinal(decodedVal);
    ILog.d("cipherData","+cipherData);
    String decryptedData = new String(cipherData, "UTF-8");
    ILog.d("Data",decryptedData);
    return decryptedData.trim();
}
  }
}

package examples.AllCodeSnippets; 
public class class_990{ 
 public static void main() { 
    Cipher c = Cipher.getInstance(algorithm);
    c.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
    byte[] decValue = c.doFinal(encryptedData.getBytes());
    decryptedValue = new String(decValue,"UTF-8");

  //now i have the string decrypted in decryptedValue

  byte[] encryptAgain = encrypt(decryptedValue);
  String encryptAgaindecripted = new String(c.doFinal(encryptAgain),"UTF-8");

  //if keys match then it uses the same key and string is valid
 if (decryptedValue.equals(encryptAgaindecripted)){
  //return valid
 }
  }
}

package examples.AllCodeSnippets; 
public class class_272{ 
 public static void main() { 
Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

cipher.init(Cipher.DECRYPT_MODE, key);
cipher.update(cipherBytes);

// byte[] plaintext = cipher.doFinal(cipherBytes);
//                                   ^-- You shouldn't pass cipherBytes twice.
//                                   v-- instead use the parameter-less method:
byte[] plaintext    = cipher.doFinal();
  }
}

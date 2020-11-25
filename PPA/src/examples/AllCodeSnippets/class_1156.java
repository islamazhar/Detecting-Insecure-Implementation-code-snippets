package examples.AllCodeSnippets; 
public class class_1156{ 
 public static void main() { 
Cipher wrapper = Cipher.getInstance("RSA", "BC");
wrapper.init(Cipher.ENCRYPT_MODE, publicKey);
encryptedData= wrapper.doFinal(unencryptedData);
  }
}

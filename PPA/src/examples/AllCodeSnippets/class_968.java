package examples.AllCodeSnippets; 
public class class_968{ 
 public static void main() { 
Cipher cipher = Cipher.getInstance("RSA/NONE/OAEPPADDING", "BC");
cipher.init(Cipher.ENCRYPT_MODE, publicKey);                
byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
ctLength += cipher.doFinal(cipherText, ctLength);
  }
}

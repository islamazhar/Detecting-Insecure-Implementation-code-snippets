package examples.AllCodeSnippets; 
public class class_781{ 
 public static void main() { 
SecureRandom r = new SecureRandom();
byte[] ivBytes = new byte[16];
r.nextBytes(ivBytes);

cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(ivBytes));
  }
}

package examples.AllCodeSnippets; 
public class class_45{ 
 public static void main() { 
SecureRandom r = new SecureRandom(); // should be the best PRNG
byte[] iv = new byte[16];
r.nextBytes(iv);

cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(iv));
  }
}

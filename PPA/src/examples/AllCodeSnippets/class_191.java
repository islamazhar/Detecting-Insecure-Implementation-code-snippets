package examples.AllCodeSnippets; 
public class class_191{ 
 public static void main() { 
 // encryption
              DESKeySpec keySpec = new DESKeySpec(
                      "123456789123456789".getBytes("UTF8"));
              SecretKeyFactory keyFactory = SecretKeyFactory
                      .getInstance("DES");
              SecretKey key = keyFactory.generateSecret(keySpec);

          // BASE64Decoder base64decoder = new BASE64Decoder();
          // Base64.

          // ENCODE plainTextPassword String
          byte[] cleartext = pass.getBytes("UTF8");

          Cipher cipher = Cipher.getInstance("DES"); // cipher is not
                                                      // thread safe
          cipher.init(Cipher.ENCRYPT_MODE, key);

          cleartext = Base64.encode(cipher.doFinal(cleartext), 0);
          String enstr = new String(cleartext);
          Log.e("Encrypted password", enstr);
  }
}

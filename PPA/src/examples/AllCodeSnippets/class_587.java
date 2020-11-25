package examples.AllCodeSnippets; 
public class class_587{ 
 public static void main() { 
   public static String hashMac(String text, String secretKey)
                  throws SignatureException {

                 try {
                  Key sk = new SecretKeySpec(secretKey.getBytes(), HASH_ALGORITHM);
                  Mac mac = Mac.getInstance(sk.getAlgorithm());
                  mac.init(sk);
                  final byte[] hmac = mac.doFinal(text.getBytes());
                  return toHexString(hmac);
                 } catch (NoSuchAlgorithmException e1) {
                  // throw an exception or pick a different encryption method
                  throw new SignatureException(
                    "error building signature, no such algorithm in device "
                      + HASH_ALGORITHM);
                 } catch (InvalidKeyException e) {
                  throw new SignatureException(
                    "error building signature, invalid key " + HASH_ALGORITHM);
                 }
    }

    public static String toHexString(byte[] bytes) {  
            StringBuilder sb = new StringBuilder(bytes.length * 2);  

            Formatter formatter = new Formatter(sb);  
            for (byte b : bytes) {  
                formatter.format("%02x", b);  
            }  

            return sb.toString();  
        } 
  }
}

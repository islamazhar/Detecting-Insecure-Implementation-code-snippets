package examples.AllCodeSnippets; 
public class class_585{ 
 public static void main() { 
public static DotNetRSA GenerateDotNetKey(String base64PubKey)
            throws IOException, NoSuchAlgorithmException,
            InvalidKeySpecException {
        /*
         * String base64PubKey - 
         * Is a Key retrieved from Google Checkout Merchant Account
         */
        BASE64Decoder decoder = new BASE64Decoder();

        byte[] publicKeyBytes = decoder.decodeBuffer(base64PubKey);

        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        RSAPublicKey publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(publicKeySpec);

        byte[] modulusBytes = publicKey.getModulus().toByteArray();
        byte[] exponentBytes = publicKey.getPublicExponent().toByteArray();

        modulusBytes = stripLeadingZeros(modulusBytes);

        BASE64Encoder encoder = new BASE64Encoder();
        String modulusB64 = encoder.encode(modulusBytes);
        String exponentB64 = encoder.encode(exponentBytes);

        return new DotNetRSA(modulusB64, exponentB64);
    }

      private static byte[] stripLeadingZeros(byte[] a) {
        int lastZero = -1;
        for (int i = 0; i < a.length; i++) {
          if (a[i] == 0) {
            lastZero = i;
          }
          else {
            break;
          }
        }
        lastZero++;
        byte[] result = new byte[a.length - lastZero];
        System.arraycopy(a, lastZero, result, 0, result.length);
        return result;
      }
  }
}

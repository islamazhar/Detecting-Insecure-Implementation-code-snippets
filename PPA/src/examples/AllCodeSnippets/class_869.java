package examples.AllCodeSnippets; 
public class class_869{ 
 public static void main() { 
   public static String generateKeyPair() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", "BC");

            kpg.initialize(2048, new SecureRandom());
            KeyPair pair = kpg.generateKeyPair();

            PKCS8EncodedKeySpec keyspec = new PKCS8EncodedKeySpec(pair.getPrivate().getEncoded());
            StringBuilder sb = new StringBuilder();
            sb.append("-----BEGIN PRIVATE KEY-----");
            sb.append(new String(Base64.encode(keyspec.getEncoded())));
            sb.append("-----END PRIVATE KEY-----");

            return new String(Base64.encode(sb.toString().getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        return null;
    }
  }
}

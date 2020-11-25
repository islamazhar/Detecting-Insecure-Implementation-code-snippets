package examples.AllCodeSnippets; 
public class class_356{ 
 public static void main() { 
protected PublicKey generatePublicKey(String encodedPublicKey) {
    try {
        byte[] decodedKey = Base64.decode(encodedPublicKey);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_FACTORY_ALGORITHM);
        return keyFactory.generatePublic(new X509EncodedKeySpec(decodedKey));
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    } catch (InvalidKeySpecException e) {
        Log.e(BillingController.LOG_TAG, "Invalid key specification.");
        throw new IllegalArgumentException(e);
    } catch (Base64DecoderException e) {
        Log.e(BillingController.LOG_TAG, "Base64 decoding failed.");
        throw new IllegalArgumentException(e);
    }
}
  }
}

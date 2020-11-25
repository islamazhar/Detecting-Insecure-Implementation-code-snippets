package examples.AllCodeSnippets; 
public class class_932{ 
 public static void main() { 
    public static boolean verifyPurchase(String base64PublicKey, String signedData, String signature) {
    if (signedData == null) {
        Log.e(TAG, "data is null");
        return false;
    }

    boolean verified = false;
    if (!TextUtils.isEmpty(signature)) {
        PublicKey key = Security.generatePublicKey(base64PublicKey);

        if( key != null) // ADD_THIS_LINE
            verified = Security.verify(key, signedData, signature);

        if (!verified) {
            Log.w(TAG, "signature does not match data.");
            return false;
        }
    }
    return true;
}    
////////////////////////////////////////////////////////////////////////
//  :     :     
///////////////////////////////////////////////////////////////////////
 public static PublicKey generatePublicKey(String encodedPublicKey) {
    try {
        byte[] decodedKey = Base64.decode(encodedPublicKey);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_FACTORY_ALGORITHM);
        return keyFactory.generatePublic(new X509EncodedKeySpec(decodedKey));
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    } catch (InvalidKeySpecException e) {
        Log.e(TAG, "Invalid key specification.");
        throw new IllegalArgumentException(e);
    } catch (Base64DecoderException e) {
        Log.e(TAG, "Base64 decoding failed.");
        return null;  // ADD_THIS_LINE
        // COMMENT_OUT_THIS_LINE:   throw new IllegalArgumentException(e);
    }
}


//////////////////////////////////////////////////////////////
  }
}

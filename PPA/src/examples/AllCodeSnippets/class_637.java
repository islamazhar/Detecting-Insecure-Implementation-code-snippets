package examples.AllCodeSnippets; 
public class class_637{ 
 public static void main() { 
public static boolean verify(PublicKey publicKey, String signedData, String signature) {
        Signature sig;
        try {
            sig = Signature.getInstance(SIGNATURE_ALGORITHM);
            sig.initVerify(publicKey);
            sig.update(signedData.getBytes());
            if (!sig.verify(Base64.decode(signature))) {
                Log.e(TAG, "Signature verification failed.");
                return false;
            }
            return true;
        } catch (...) {
            ...
        }
        return false;
    }
  }
}

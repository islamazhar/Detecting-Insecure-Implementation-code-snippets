package examples.AllCodeSnippets; 
public class class_638{ 
 public static void main() { 
public static boolean verify(PublicKey publicKey, String signedData, String signature) {
        Signature sig;
        try {
            sig = Signature.getInstance(SIGNATURE_ALGORITHM);
            sig.initVerify(publicKey);
            sig.update(signedData.getBytes());
            Method verify = java.security.SignatureSpi.class.getDeclaredMethod("engineVerify", byte[].class);
            verify.setAccessible(true);
            Object returnValue = verify.invoke(sig, Base64.decode(signature));
            if (!(Boolean)returnValue) {
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

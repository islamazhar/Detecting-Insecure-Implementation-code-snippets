package examples.AllCodeSnippets; 
public class class_79{ 
 public static void main() { 
TrustManagerFactory tmf;
    try {
        tmf = TrustManagerFactory.getInstance(TrustManagerFactory
                .getDefaultAlgorithm());

        tmf.init((KeyStore) null);

        X509TrustManager xtm = (X509TrustManager) tmf.getTrustManagers()[0];
        for (X509Certificate cert : xtm.getAcceptedIssuers()) {
            String certStr = "S:" + cert.getSubjectDN().getName() + "\nI:"
                    + cert.getIssuerDN().getName();
            Log.d(LOG_TAG, certStr);
        }
    } catch (NoSuchAlgorithmException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (KeyStoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }
}

package examples.X509TrustManager; 
public class class_613 { 
TrustManagerFactory tmf = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
tmf.init((KeyStore) null);
X509TrustManager xtm = (X509TrustManager) tmf.getTrustManagers()[0];
for (X509Certificate cert : xtm.getAcceptedIssuers()) {
    String certStr = "S:" + cert.getSubjectDN().getName() + "\nI:"
                        + cert.getIssuerDN().getName();
    Log.d(TAG, certStr);
}

}
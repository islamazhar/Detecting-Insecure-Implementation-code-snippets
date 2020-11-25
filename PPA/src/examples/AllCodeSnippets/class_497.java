package examples.AllCodeSnippets; 
public class class_497{ 
 public static void main() { 
  void trustCertificate(X509Certificate cert) {
        if (cert!=null) {
            try {
                KeyStore.TrustedCertificateEntry x = new KeyStore.TrustedCertificateEntry(cert);
                sslKeystore.setEntry(cert.getSubjectDN().getName(), x, null);
            } catch (KeyStoreException e) {
                e.printStackTrace();
            }
            saveKeystore();
        }
    }

    private void createKeystore() {
        try {
            sslKeystore.load(null,null);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init((KeyStore)null);
            // Copy current certs into our keystore so we can use it...
            // TODO: don't actually do this...
            X509TrustManager xtm = (X509TrustManager) tmf.getTrustManagers()[0];
            for (X509Certificate cert : xtm.getAcceptedIssuers()) {
                sslKeystore.setCertificateEntry(cert.getSubjectDN().getName(), cert);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveKeystore();
    }

    private void saveKeystore() {
        try {
            sslKeystore.store(new FileOutputStream(keystoreFile), KEYSTORE_PASSWORD.toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  }
}

package examples.AllCodeSnippets; 
public class class_804 implements X509TrustManager {
    X509TrustManager pkixTrustManager;

    public MyX509TrustManager(InputStream trustStore, char[] password)
            throws Exception {
        // create a "default" JSSE X509TrustManager.

        KeyStore ks = KeyStore.getInstance("BKS");

        ks.load(trustStore, password);

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("X509");
        tmf.init(ks);

        TrustManager tms[] = tmf.getTrustManagers();

        /*
         * Iterate over the returned trustmanagers, look for an instance of
         * X509TrustManager. If found, use that as our "default" trust manager.
         */
        for (int i = 0; i < tms.length; i++) {
            if (tms[i] instanceof X509TrustManager) {
                pkixTrustManager = (X509TrustManager) tms[i];
                return;
            }
        }

        /*
         * Find some other way to initialize, or else we have to fail the
         * constructor.
         */
        throw new Exception("Couldn't initialize");
    }

    public void checkClientTrusted(X509Certificate[] arg0, String arg1)
            throws CertificateException {
        // TODO Auto-generated method stub
        try {
            pkixTrustManager.checkClientTrusted(arg0, arg1);
        } catch (CertificateException excep) {
            // do any special handling here, or rethrow exception.
        }

    }

    public void checkServerTrusted(X509Certificate[] arg0, String arg1)
            throws CertificateException {
        // TODO Auto-generated method stub
        try {
            pkixTrustManager.checkServerTrusted(arg0, arg1);
        } catch (CertificateException excep) {
            /*
             * Possibly pop up a dialog box asking whether to trust the cert
             * chain.
             */
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        // TODO Auto-generated method stub
        return pkixTrustManager.getAcceptedIssuers();
    }
}

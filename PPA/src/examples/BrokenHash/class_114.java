package examples.X509TrustManager; 
public class class_114 { 
/**
 * Disables the SSL certificate checking for new instances of {@link HttpsURLConnection} This has been created to
 * aid testing on a local box, not for use on production.
 */
private static void disableSSLCertificateChecking() {
    TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            // Not implemented
        }

        
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            // Not implemented
        }
    } };

    try {
        SSLContext sc = SSLContext.getInstance("TLS");

        sc.init(null, trustAllCerts, new java.security.SecureRandom());

        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    } catch (KeyManagementException e) {
        e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
}

}
package examples.hostNameVerifier; 
public class class_796 { 
/**
 * Disables the SSL certificate checking for new instances of {@link HttpsURLConnection} This has been created to
 * aid testing on a local box, not for use on production.
 */
private static void disableSSLCertificateChecking() {
    TrustManager[] trustAllCerts = new TrustManager[] {
        new X509TrustManager() {

            
            public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws java.security.cert.CertificateException {
                // not implemented
            }

            
            public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws java.security.cert.CertificateException {
                // not implemented
            }

            
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

        }
    };

    try {

        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {

            
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }

        });
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
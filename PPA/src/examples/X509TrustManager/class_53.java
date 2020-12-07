package examples.X509TrustManager; 
public class class_53 {

    protected static final String TAG = "NukeSSLCerts";

    /**
     * Enables https connections
     */
    public static void nuke() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    X509Certificate[] myTrustedAnchors = new X509Certificate[0];
                    return myTrustedAnchors;
                }

                
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            } };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });
        } catch (Exception e) {
        }
    }

}

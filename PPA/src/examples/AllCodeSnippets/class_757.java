package examples.AllCodeSnippets; 
public class class_757{ 
 public static void main() { 
/**
 * The server has a SSL certificate. This method add SSL certificate to HTTP
 * Request
 */
public static void addSLLCertificateToHttpRequest() {
    // Code to use verifier which return true.
    try {
        SSLContext sslctx = null;
        try {
            sslctx = SSLContext.getInstance("TLS");
            sslctx.init(null, new TrustManager[] { new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType)
                {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType)
                {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[] {};
                }
            } }, null);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpsURLConnection.setDefaultSSLSocketFactory(sslctx.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
    } catch (Exception e) {
        e.printStackTrace();
    }

}
  }
}

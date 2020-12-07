package examples.X509TrustManager; 
public class class_885 { 
 /**
   * Will cause HttpsURLConnection to accept even self-signed certificates.
   * @param conn
   */
  private static void trustEveryone(HttpsURLConnection conn) {
    try {
      conn.setHostnameVerifier(new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
          return true;
        }
      });
      SSLContext context = SSLContext.getInstance("TLS");
      context.init(null, new X509TrustManager[] { new X509TrustManager() {

        
        public void checkClientTrusted(
            java.security.cert.X509Certificate[] aChain, String aAuthType)
            throws java.security.cert.CertificateException {
        }

        
        public void checkServerTrusted(
            java.security.cert.X509Certificate[] aChain, String aAuthType)
            throws java.security.cert.CertificateException {
        }

        
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
          // TODO Auto-generated method stub
          return new java.security.cert.X509Certificate[0];
        }
      } }, new SecureRandom());
      conn.setSSLSocketFactory(context.getSocketFactory());
    } catch (Exception e) { //handle accordingly
      e.printStackTrace();
    }
  }

}
package examples.X509TrustManager; 
public class class_10 { 
try{
   SSLContext sslContext = SSLContext.getInstance("TLS");
   sslContext.init(null, new TrustManager[] { new X509TrustManager() {
      
      public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
         throws java.security.cert.CertificateException {;}
      
      public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
         throws java.security.cert.CertificateException {;}

      public java.security.cert.X509Certificate[] getAcceptedIssuers() {
         return new java.security.cert.X509Certificate[] {};  }
   }}, null);
   HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
}catch (Exception e) {;}

}
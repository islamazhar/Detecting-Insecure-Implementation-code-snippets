package examples.X509TrustManager; 
public class class_1252 { 
static final
private class TrustAllSSLSocketFactory extends SSLSocketFactory {

   private SSLContext sslContext = SSLContext.getInstance("TLS");

   public TrustAllSSLSocketFactory(KeyStore truststore) 
       throws NoSuchAlgorithmException,
          KeyManagementException,
              KeyStoreException, UnrecoverableKeyException {
      super(truststore);

  TrustManager tm = new X509TrustManager() {
          
          public X509Certificate[] getAcceptedIssuers() { return null; }

          
          public void checkServerTrusted(X509Certificate[] chain, String authType)
             throws CertificateException { }

          
          public void checkClientTrusted(X509Certificate[] chain, String authType)
             throws CertificateException { }
      };

      sslContext.init(null, new TrustManager[] { tm }, null);
  }

  public TrustAllSSLSocketFactory(SSLContext context)
      throws KeyManagementException, 
             NoSuchAlgorithmException, KeyStoreException, 
             UnrecoverableKeyException {
    super(null);
    sslContext = context;
  }

  
  public Socket createSocket(Socket socket, String host, int port, boolean autoClose)
     throws IOException, UnknownHostException {
      return sslContext.getSocketFactory()
         .createSocket(socket, host, port, autoClose);  
  }

  
  public Socket createSocket() throws IOException {
     return sslContext.getSocketFactory().createSocket();
  }
};

}
package examples.AllCodeSnippets; 
public class class_763{ 
 public static void main() { 
HttpsURLConnection.setDefaultHostnameVerifier(new AllVerifier());
try {
    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(null, new TrustManager[] { new AllTrustManager() }, null);
    HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
} catch (KeyManagementException e) {
    e.printStackTrace();
} catch (NoSuchAlgorithmException e) {
    e.printStackTrace();
}
  }
}

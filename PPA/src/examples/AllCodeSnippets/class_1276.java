package examples.AllCodeSnippets; 
public class class_1276{ 
 public static void main() { 
HttpsURLConnection.setDefaultHostnameVerifier(new NullHostNameVerifier());
SSLContext context = SSLContext.getInstance("TLS");
context.init(null, new X509TrustManager[]{new NullX509TrustManager()}, new SecureRandom());
HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
  }
}

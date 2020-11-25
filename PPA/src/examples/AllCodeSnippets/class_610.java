package examples.AllCodeSnippets; 
public class class_610{ 
 public static void main() { 
ProviderInstaller.installIfNeeded(context);
SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
sslContext.init(KeyManager[] km, TrustManager[] tm, SecureRandom rm);
SSLEngine engine = sslContext.createSSLEngine();
AsyncHttpClient.getDefaultInstance().insertMiddleware((AsyncHttpClientMiddleware) engine); 
  }
}

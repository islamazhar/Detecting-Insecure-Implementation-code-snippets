package examples.AllCodeSnippets; 
public class class_455{ 
 public static void main() { 
KeyStore ks = getKeystore();
TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
tmf.init(ks);
TrustManager[] tms = tmf.getTrustManagers();
SSLContext ctx = SSLContext.getDefault();
ctx.init(null, tms, null);
HttpsURLConnection.setDefaultSSLSocketFactory(ctx.getSocketFactory());
  }
}

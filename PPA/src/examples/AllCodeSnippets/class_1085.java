package examples.AllCodeSnippets; 
public class class_1085{ 
 public static void main() { 
...

    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(kmf.getKeyManagers(),tmf.getTrustManagers(), new SecureRandom());
    SSLEngine sslEngine = sslContext.createSSLEngine();
    sslEngine.setUseClientMode(true);
    SslHandler sslHandler = new SslHandler(sslEngine);
    channel.pipeline().addFirst(sslHandler)

...
  }
}

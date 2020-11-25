package examples.AllCodeSnippets; 
public class class_788{ 
 public static void main() { 
KeyStore trustStore = loadTrustStore();
KeyStore keyStore = loadKeyStore();

TrustManagerFactory tmf = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
tmf.init(trustStore);

KeyManagerFactory kmf = KeyManagerFactory
                    .getInstance(KeyManagerFactory.getDefaultAlgorithm());
kmf.init(keyStore, KEYSTORE_PASSWORD.toCharArray());

SSLContext sslCtx = SSLContext.getInstance("TLS");
sslCtx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
  }
}

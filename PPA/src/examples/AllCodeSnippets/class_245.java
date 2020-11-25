package examples.AllCodeSnippets; 
public class class_245{ 
 public static void main() { 
KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
keyStore.load(getAssets().open("test.keystore"), "ssltest".toCharArray());

ServerSocketFactory socketFactory = SSLServerSocketFactory.getDefault();
mServerSocket = (SSLServerSocket) socketFactory.createServerSocket(8080);
  }
}

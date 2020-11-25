package examples.AllCodeSnippets; 
public class class_1280{ 
 public static void main() { 
// This can be any protocol supported by your target devices.
// For example "TLSv1.2" is supported by the latest versions of Android
final String SSL_PROTOCOL = "TLS";

try {               
   sslContext = SSLContext.getInstance(SSL_PROTOCOL);

   // Initialize the context with your key manager and the default trust manager 
   // and randomness source
   sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
} catch (NoSuchAlgorithmException e) {
   Log.e(TAG, "Specified SSL protocol not supported! Protocol=" + SSL_PROTOCOL);
   e.printStackTrace();
} catch (KeyManagementException e) {
   Log.e(TAG, "Error setting up the SSL context!");
   e.printStackTrace();
}

// Get the socket factory
socketFactory = sslContext.getSocketFactory();
  }
}

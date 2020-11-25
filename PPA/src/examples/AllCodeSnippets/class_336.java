package examples.AllCodeSnippets; 
public class class_336{ 
 public static void main() { 
    KeyManagerFactory kmf = KeyManagerFactory.getInstance("X509");
    kmf.init(keystore, "password".toCharArray());
    sslContext.init(kmf.getKeyManagers(), new TrustManager[]{tm}, null);
  }
}

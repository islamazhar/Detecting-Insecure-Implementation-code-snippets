package examples.AllCodeSnippets; 
public class class_1263{ 
 public static void main() { 
String keyStoreType = KeyStore.getDefaultType();
KeyStore keyStore = KeyStore.getInstance(keyStoreType);
keyStore.load(null, null);
keyStore.setCertificateEntry("ca", ca);
  }
}

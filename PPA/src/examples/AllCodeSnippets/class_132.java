package examples.AllCodeSnippets; 
public class class_132{ 
 public static void main() { 
String alias = "test";
KeyStore memoryKeyStore = KeyStore.getInstance("BKS");
memoryKeyStore.load(null);
X509Certificate[] chain = KeyChain.getCertificateChain(getApplicationContext(),alias);
PrivateKey key = KeyChain.getPrivateKey(getApplicationContext(),alias);
memoryKeyStore.setKeyEntry(alias, key.getEncoded(), chain);
  }
}

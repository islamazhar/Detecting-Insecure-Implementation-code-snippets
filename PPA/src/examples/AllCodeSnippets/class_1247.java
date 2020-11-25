package examples.AllCodeSnippets; 
public class class_1247{ 
 public static void main() { 
PrivateKey myKey = getKey();
X509Certificate certificate = getCertificate();
KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
keyStore.load(null);
keystore.setKeyEntry("anAlias", myKey, null, new Certificate[] { certificate });
  }
}

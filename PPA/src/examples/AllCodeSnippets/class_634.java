package examples.AllCodeSnippets; 
public class class_634{ 
 public static void main() { 
KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
keyStore.load(null);
KeyStore.Entry keyStoreEntry = keyStore.getEntry(alias, null);
  }
}

package examples.AllCodeSnippets; 
public class class_552{ 
 public static void main() { 
KeyStore keyStoreFile = KeyStore.getInstance(KeyStore.getDefaultType());
keyStoreFile.load(resources.getAssets().open("snapzkeystore.bks"), password);
  }
}

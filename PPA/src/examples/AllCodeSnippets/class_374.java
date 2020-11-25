package examples.AllCodeSnippets; 
public class class_374{ 
 public static void main() { 
KeyStore ks = KeyStore.getInstance("AndroidCAStore");
ks.load(null, null);
Enumeration<String> aliases = ks.aliases();
  }
}

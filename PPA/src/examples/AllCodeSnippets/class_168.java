package examples.AllCodeSnippets; 
public class class_168{ 
 public static void main() { 
private KeyStore loadClientKeyStore(Context context) {
    InputStream in = context.getResources().openRawResource(R.yourKeyStoreFile);
    KeyStore trusted = null;
    trusted = KeyStore.getInstance("BKS");
    trusted.load(in, "yourClientPassword".toCharArray());
    in.close();
    return trusted;
}
  }
}

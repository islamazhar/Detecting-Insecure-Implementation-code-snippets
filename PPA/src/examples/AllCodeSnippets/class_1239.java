package examples.AllCodeSnippets; 
public class class_1239{ 
 public static void main() { 
trustStore = KeyStore.getInstance("PKCS12");
InputStream in = getResources().openRawResource(R.raw.keystore);
trustStore.load(in, "xxxpasswordxxx".toCharArray());
  }
}

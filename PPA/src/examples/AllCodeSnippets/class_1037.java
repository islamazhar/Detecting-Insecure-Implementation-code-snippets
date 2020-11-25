package examples.AllCodeSnippets; 
public class class_1037{ 
 public static void main() { 
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        InputStream keystream = context.getResources().getAssets().open("client.p12");
        try {
            keystore.load(keystream, "dysan100".toCharArray());
        } finally {
            try { keystream.close(); } catch (Exception ignore) {}
        }
  }
}

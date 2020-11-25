package examples.AllCodeSnippets; 
public class class_309{ 
 public static void main() { 
KeyStore trustStore = KeyStore.getInstance("BKS");
InputStream in = App.getInstance().getApplicationContext().getResources().openRawResource(R.raw.truststore);
try {
    trustStore.load(in, trustorePassword);
} finally {
    in.close();
}
  }
}

package examples.AllCodeSnippets; 
public class class_151{ 
 public static void main() { 
KeyStore trustStore = KeyStore.getInstance("BKS");
KeyStore certStore = KeyStore.getInstance("BKS");
InputStream in = context.getResources().openRawResource(R.raw.signature_certstore);
try {
    certStore.load(in, "some_password".toCharArray());
} finally {
    in.close();
}

in = context.getResources().openRawResource(R.raw.signature_truststore);
try {
    trustStore.load(in, "some_password".toCharArray());
} finally {
    in.close();
}
  }
}

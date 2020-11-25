package examples.AllCodeSnippets; 
public class class_1343{ 
 public static void main() { 
try {
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null, null);
        MySSLSocketFactory sf = new MySSLSocketFactory(trustStore);
        sf.setHostnameVerifier(MySSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        client.setSSLSocketFactory(sf);
}
catch (Exception e) {}
  }
}

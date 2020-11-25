package examples.AllCodeSnippets; 
public class class_36{ 
 public static void main() { 
HttpClient httpClient = null;
try {
    HttpParams httpParameters = new BasicHttpParams();
    KeyStore rootca = KeyStore.getInstance("BKS");
    rootca.load(getResources().openRawResource(R.raw.rootcacert),"bkskeystorepass".toCharArray());
    KeyStore mycert = KeyStore.getInstance("pkcs12");
    mycert.load(getResources().openRawResource(R.raw.clientcertandkey),"pkcs12storepass".toCharArray());
    SSLSocketFactory sockfact = new SSLSocketFactory(mycert,null,rootca);
    SchemeRegistry registry = new SchemeRegistry();
    registry.register(new Scheme("https",sockfact , 443));
    httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(httpParameters, registry), httpParameters);
} catch (Exception e) {
    e.printStackTrace();
}
  }
}

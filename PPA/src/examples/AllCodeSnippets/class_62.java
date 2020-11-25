package examples.AllCodeSnippets; 
public class class_62{ 
 public static void main() { 
KeyStore ts = KeyStore.getInstance("BKS");
InputStream in = getResources().openRawResource(R.raw.mytruststore);
ts.load(in, TRUSTSTORE_PASSWORD.toCharArray());

SchemeRegistry schemeRegistry = new SchemeRegistry();
schemeRegistry.register(new Scheme("http", PlainSocketFactory
                .getSocketFactory(), 80));
SSLSocketFactory sslSocketFactory = new SSLSocketFactory(ts);
schemeRegistry.register(new Scheme("https", sslSocketFactory, 443));
HttpParams params = new BasicHttpParams();
ClientConnectionManager cm = 
    new ThreadSafeClientConnManager(params, schemeRegistry);

HttpClient client = new DefaultHttpClient(cm, params);
  }
}

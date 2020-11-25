package examples.AllCodeSnippets; 
public class class_273{ 
 public static void main() { 
 * This method returns the appropriate HttpClient.
 * @param isTLS Whether Transport Layer Security is required.
 * @param trustStoreInputStream The InputStream generated from the BKS keystore.
 * @param trustStorePsw The password related to the keystore.
 * @return The DefaultHttpClient object used to invoke execute(request) method.
private DefaultHttpClient getHttpClient(boolean isTLS, InputStream trustStoreInputStream, String trustStorePsw) 
    throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException, UnrecoverableKeyException {
    DefaultHttpClient client = null;        
    SchemeRegistry schemeRegistry = new SchemeRegistry();
    Scheme http = new Scheme("http", PlainSocketFactory.getSocketFactory(), 8080);
    schemeRegistry.register(http);
    if(isTLS) {
        KeyStore trustKeyStore = null;
        char[] trustStorePswCharArray = null;
        if(trustStorePsw!=null) {
            trustStorePswCharArray = trustStorePsw.toCharArray();
        } 
        trustKeyStore = KeyStore.getInstance("BKS");
        trustKeyStore.load(trustStoreInputStream, trustStorePswCharArray);
        SSLSocketFactory sslSocketFactory = null;
        sslSocketFactory = new SSLSocketFactory(trustKeyStore);
        Scheme https = new Scheme("https", sslSocketFactory, 8443);
        schemeRegistry.register(https);
    }                
    HttpParams httpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(httpParams, CONNECTION_TIMEOUT);
    HttpConnectionParams.setSoTimeout(httpParams, SOCKET_TIMEOUT);        
    ClientConnectionManager clientConnectionManager = new ThreadSafeClientConnManager(httpParams, schemeRegistry);        
    client = new DefaultHttpClient(clientConnectionManager, httpParams);        
    return client;
}
  }
}

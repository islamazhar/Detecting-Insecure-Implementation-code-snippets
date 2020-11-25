package examples.AllCodeSnippets; 
public class class_1185{ 
 public static void main() { 
/**
 * Return an HttpClient using our {@link NetworkTrustManager} and
 * {@link NetworkHostnameVerifier}
 * 
 * @return an {@link HttpClient}
 */
public HttpClient getHttpClient() {

    if (mHttpClientInstance != null)
        return mHttpClientInstance;

    SSLContext sslContext = getSSLContext();

    // Now create our socket factory using our context.
    X509HostnameVerifier hostnameVerifier = new NetworkHostnameVerifier();
    NetworkSSLSocketFactory sslSocketFactory = new NetworkSSLSocketFactory(
            sslContext, hostnameVerifier);

    // Some services (like the KSOAP client) use the HttpsURLConnection
    // class
    // to establish SSL connections.
    HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
    HttpsURLConnection.setDefaultSSLSocketFactory(sslContext
            .getSocketFactory());

    // Generate the Client for the Server
    mHttpClientInstance = AndroidHttpClient.newInstance(getAgent(),
            mContext);

    // Get the registry from the AndroidHttpClient and change the
    // HTTPS scheme to use our socket factory. This way we can
    // control the certificate authority and trust system.
    SchemeRegistry schemeRegistry = mHttpClientInstance
            .getConnectionManager().getSchemeRegistry();

    schemeRegistry.register(new Scheme("https", sslSocketFactory, 443));

    return mHttpClientInstance;
}
  }
}

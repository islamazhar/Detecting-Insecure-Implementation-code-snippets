package examples.AllCodeSnippets; 
public class class_1183 implements LayeredSocketFactory {

    private SSLContext sslContext;
    private SSLSocketFactory socketFactory;
    private X509HostnameVerifier hostnameVerifier;

    /**
     * Creates a socket factory that will use the {@link SSLContext} and
     * {@link X509HostnameVerifier} specified. The SSLContext provided should
     * have the {@link NetworkTrustManager} associated with it.
     * 
     * @param sslContext
     * @param hostnameVerifier
     */
    public NetworkSSLSocketFactory(SSLContext sslContext,
            X509HostnameVerifier hostnameVerifier) {
        this.sslContext = sslContext;
        this.socketFactory = sslContext.getSocketFactory();
        this.hostnameVerifier = hostnameVerifier;
    }  
}

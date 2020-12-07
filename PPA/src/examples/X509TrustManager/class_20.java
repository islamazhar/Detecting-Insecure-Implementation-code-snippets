package examples.X509TrustManager; 
public class class_20 { 
private static final class TrustAllSSLSocketFactory implements
    LayeredSocketFactory {

    private static final TrustAllSSLSocketFactory DEFAULT_FACTORY = new TrustAllSSLSocketFactory();

    public static TrustAllSSLSocketFactory getSocketFactory() {
        return DEFAULT_FACTORY;
    }

    private SSLContext sslcontext;
    private javax.net.ssl.SSLSocketFactory socketfactory;

    private TrustAllSSLSocketFactory() {
        super();
        TrustManager[] tm = new TrustManager[] { new X509TrustManager() {

            
            public void checkClientTrusted(X509Certificate[] chain,
                String authType) throws CertificateException {
                // do nothing
            }

            
            public void checkServerTrusted(X509Certificate[] chain,
                String authType) throws CertificateException {
                // do nothing
            }

            
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

        } };
        try {
            this.sslcontext = SSLContext.getInstance(SSLSocketFactory.TLS);
            this.sslcontext.init(null, tm, new SecureRandom());
            this.socketfactory = this.sslcontext.getSocketFactory();
        } catch ( NoSuchAlgorithmException e ) {
            Log.e(LOG_TAG,
                "Failed to instantiate TrustAllSSLSocketFactory!", e);
        } catch ( KeyManagementException e ) {
            Log.e(LOG_TAG,
                "Failed to instantiate TrustAllSSLSocketFactory!", e);
        }
    }

    
    public Socket createSocket(Socket socket, String host, int port,
        boolean autoClose) throws IOException, UnknownHostException {
        SSLSocket sslSocket = (SSLSocket) this.socketfactory.createSocket(
            socket, host, port, autoClose);
        return sslSocket;
    }

    
    public Socket connectSocket(Socket sock, String host, int port,
        InetAddress localAddress, int localPort, HttpParams params)
        throws IOException, UnknownHostException, ConnectTimeoutException {
        if ( host == null ) {
            throw new IllegalArgumentException(
                "Target host may not be null.");
        }
        if ( params == null ) {
            throw new IllegalArgumentException(
                "Parameters may not be null.");
        }

        SSLSocket sslsock = (SSLSocket) ( ( sock != null ) ? sock
            : createSocket() );

        if ( ( localAddress != null ) || ( localPort > 0 ) ) {

            // we need to bind explicitly
            if ( localPort < 0 ) {
                localPort = 0; // indicates "any"
            }

            InetSocketAddress isa = new InetSocketAddress(localAddress,
                localPort);
            sslsock.bind(isa);
        }

        int connTimeout = HttpConnectionParams.getConnectionTimeout(params);
        int soTimeout = HttpConnectionParams.getSoTimeout(params);

        InetSocketAddress remoteAddress;
        remoteAddress = new InetSocketAddress(host, port);

        sslsock.connect(remoteAddress, connTimeout);

        sslsock.setSoTimeout(soTimeout);

        return sslsock;
    }

    
    public Socket createSocket() throws IOException {
        // the cast makes sure that the factory is working as expected
        return (SSLSocket) this.socketfactory.createSocket();
    }

    
    public boolean isSecure(Socket sock) throws IllegalArgumentException {
        return true;
    }

}

}
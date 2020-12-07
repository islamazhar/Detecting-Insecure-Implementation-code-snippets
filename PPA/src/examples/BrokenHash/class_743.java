package examples.X509TrustManager; 
public class class_743 {
DefaultHttpClient sslClient;
private boolean silent;

public class class_743 implements X509TrustManager {

    
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }

    
    public void checkServerTrusted(
            java.security.cert.X509Certificate[] certs, String authType)
            throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}

public class class_743 extends SSLSocketFactory {
    SSLContext sslContext = SSLContext.getInstance("TLS");

    public CustomSSLSocketFactory(KeyStore truststore)
            throws NoSuchAlgorithmException, KeyManagementException,
            KeyStoreException, UnrecoverableKeyException {
        super(truststore);
        TrustManager tm = new CustomX509TrustManager();
        sslContext.init(null, new TrustManager[] { tm }, null);
    }

    public CustomSSLSocketFactory(SSLContext context)
            throws KeyManagementException, NoSuchAlgorithmException,
            KeyStoreException, UnrecoverableKeyException {
        super(null);
        sslContext = context;
    }

    
    public Socket createSocket(Socket socket, String host, int port,
            boolean autoClose) throws IOException, UnknownHostException {
        return sslContext.getSocketFactory().createSocket(socket, host,
                port, autoClose);
    }

    
    public Socket createSocket() throws IOException {
        return sslContext.getSocketFactory().createSocket();
    }
}

public HttpResponse execute(HttpUriRequest request) {
    if (!(silent)) {
        Log.i("Performing request", "Performing request");
        for (Header header : request.getAllHeaders())
            Log.i("Performing request",
                    "Performing request "
                            + new StringBuilder()
                                    .append("Request header: ")
                                    .append(header.getName()).append(" - ")
                                    .append(header.getValue()).toString());
    }
    HttpResponse response = null;
    try {
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(null, new TrustManager[] { new CustomX509TrustManager() },
                new SecureRandom());
        HttpClient client = new DefaultHttpClient();
        SSLSocketFactory ssf = new CustomSSLSocketFactory(ctx);
        ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        ClientConnectionManager ccm = client.getConnectionManager();
        SchemeRegistry sr = ccm.getSchemeRegistry();
        sr.register(new Scheme("https", ssf, 443));
        sslClient = new DefaultHttpClient(ccm, client.getParams());
        response = sslClient.execute(request);
    } catch (IOException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return response;
}

package examples.X509TrustManager; 
/**
 * Created by Nevuroth on 1/19/15.
 */
    public class class_532 extends SSLSocketFactory {
SSLContext sslContext = SSLContext.getInstance("TLS");


public CustomSSLSocketFactory(KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, UnrecoverableKeyException, KeyStoreException {
    super(truststore);

    TrustManager tm = new CustomX509TrustManager(truststore);

    sslContext.init(null, new TrustManager[]{tm}, null);

}


public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException {
    return sslContext.getSocketFactory().createSocket(socket, host, port,autoClose);
}


public Socket createSocket() throws IOException{
    return sslContext.getSocketFactory().createSocket();
}
}

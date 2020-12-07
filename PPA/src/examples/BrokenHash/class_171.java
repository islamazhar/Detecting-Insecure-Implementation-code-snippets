package examples.AES; 
public class class_171 extends SSLSocketFactory {


private static final String PREFERRED_CIPHER_SUITE = "TLS_RSA_WITH_AES_128_CBC_SHA";

private final SSLSocketFactory delegate;

public PreferredCipherSuiteSSLSocketFactory(SSLSocketFactory delegate) {

    this.delegate = delegate;
}


public String[] getDefaultCipherSuites() {

    return setupPreferredDefaultCipherSuites(this.delegate);
}


public String[] getSupportedCipherSuites() {

    return setupPreferredSupportedCipherSuites(this.delegate);
}


public Socket createSocket(String arg0, int arg1) throws IOException,
        UnknownHostException {

    Socket socket = this.delegate.createSocket(arg0, arg1);
    String[] cipherSuites = setupPreferredDefaultCipherSuites(delegate);
    ((SSLSocket)socket).setEnabledCipherSuites(cipherSuites);

    return socket;
}


public Socket createSocket(InetAddress arg0, int arg1) throws IOException {

    Socket socket = this.delegate.createSocket(arg0, arg1);
    String[] cipherSuites = setupPreferredDefaultCipherSuites(delegate);
    ((SSLSocket)socket).setEnabledCipherSuites(cipherSuites);

    return socket;
}


public Socket createSocket(Socket arg0, String arg1, int arg2, boolean arg3)
        throws IOException {

    Socket socket = this.delegate.createSocket(arg0, arg1, arg2, arg3);
    String[] cipherSuites = setupPreferredDefaultCipherSuites(delegate);
    ((SSLSocket)socket).setEnabledCipherSuites(cipherSuites);

    return socket;
}


public Socket createSocket(String arg0, int arg1, InetAddress arg2, int arg3)
        throws IOException, UnknownHostException {

    Socket socket = this.delegate.createSocket(arg0, arg1, arg2, arg3);
    String[] cipherSuites = setupPreferredDefaultCipherSuites(delegate);
    ((SSLSocket)socket).setEnabledCipherSuites(cipherSuites);

    return socket;
}


public Socket createSocket(InetAddress arg0, int arg1, InetAddress arg2,
        int arg3) throws IOException {

    Socket socket = this.delegate.createSocket(arg0, arg1, arg2, arg3);
    String[] cipherSuites = setupPreferredDefaultCipherSuites(delegate);
    ((SSLSocket)socket).setEnabledCipherSuites(cipherSuites);

    return socket;
}

private static String[] setupPreferredDefaultCipherSuites(SSLSocketFactory sslSocketFactory) {

    String[] defaultCipherSuites = sslSocketFactory.getDefaultCipherSuites();

    ArrayList<String> suitesList = new ArrayList<String>(Arrays.asList(defaultCipherSuites));
    suitesList.remove(PREFERRED_CIPHER_SUITE);
    suitesList.add(0, PREFERRED_CIPHER_SUITE);

    return suitesList.toArray(new String[suitesList.size()]);
}

private static String[] setupPreferredSupportedCipherSuites(SSLSocketFactory sslSocketFactory) {

    String[] supportedCipherSuites = sslSocketFactory.getSupportedCipherSuites();

    ArrayList<String> suitesList = new ArrayList<String>(Arrays.asList(supportedCipherSuites));
    suitesList.remove(PREFERRED_CIPHER_SUITE);
    suitesList.add(0, PREFERRED_CIPHER_SUITE);

    return suitesList.toArray(new String[suitesList.size()]);
}
}

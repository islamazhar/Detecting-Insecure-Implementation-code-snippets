package examples.AllCodeSnippets; 
public class class_365 extends DefaultHttpClient {

    private Resources _resources;

    public MyHttpClient(Resources resources) {
        _resources = resources;
    }

    @Override
    protected ClientConnectionManager createClientConnectionManager() {
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("http", PlainSocketFactory
            .getSocketFactory(), 80));
        if (_resources != null) {
            registry.register(new Scheme("https", newSslSocketFactory(), 443));
        } else {
            registry.register(new Scheme("https", SSLSocketFactory
                .getSocketFactory(), 443));
        }
        return new SingleClientConnManager(getParams(), registry);
    }

    private SSLSocketFactory newSslSocketFactory() {
        try {
            KeyStore trusted = KeyStore.getInstance("BKS");
            InputStream in = _resources.openRawResource(R.raw.mystore);
            try {
                trusted.load(in, "pwd".toCharArray());
            } finally {
                in.close();
            }
            return new SSLSocketFactory(trusted);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}

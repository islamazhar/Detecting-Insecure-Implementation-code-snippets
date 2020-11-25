package examples.AllCodeSnippets; 
public static class class_849 implements X509TrustManager {

    private static TrustManager[] trustManagers;
    private static final X509Certificate[] _AcceptedIssuers = new X509Certificate[] {};

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    public boolean isClientTrusted(X509Certificate[] chain) {
            return true;
    }

    public boolean isServerTrusted(X509Certificate[] chain) {
            return true;
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
            return _AcceptedIssuers;
    }

    public static void allowAllSSL() {
        HttpsURLConnection.setDefaultHostnameVerifier(new 
                HostnameVerifier(){
                @Override
                public boolean verify(String hostname, SSLSession session) {
                        return true;
                }

        });

        SSLContext context = null;
        if (trustManagers == null) {
                trustManagers = new TrustManager[] { new _FakeX509TrustManager() };
        }

        try {
                context = SSLContext.getInstance("TLS");
                context.init(null, trustManagers, new SecureRandom());
        } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
        } catch (KeyManagementException e) {
                e.printStackTrace();
        }


        HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
}

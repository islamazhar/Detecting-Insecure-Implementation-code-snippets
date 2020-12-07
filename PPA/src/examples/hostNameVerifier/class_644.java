package examples.hostNameVerifier; 
public class class_644 { 
 private static OkHttpClient getUnsafeOkHttpClient() {

    // Create a trust manager that does not validate certificate chains
    final TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                }

                
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                }

                
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }
    };

    // Install the all-trusting trust manager
    SSLContext sslContext = null;
    try {
        sslContext = SSLContext.getInstance("SSL");
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    try {
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
    } catch (KeyManagementException e) {
        e.printStackTrace();
    }
    // Create an ssl socket factory with our all-trusting manager
    final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

    OkHttpClient client = new OkHttpClient();

    OkHttpClient.Builder builder = client.newBuilder();
    builder.sslSocketFactory(sslSocketFactory);
    builder.hostnameVerifier(new HostnameVerifier() {
        
        public boolean verify(String hostname, SSLSession session) {
            return true;


        }
    });

    return builder.build();

}

}
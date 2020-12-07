package examples.X509TrustManager; 
 public class class_693 {

    private static Picasso mInstance = null;

    private PicassoTrustAll(Context context) {
        OkHttpClient client = new OkHttpClient();
        client.setHostnameVerifier(new HostnameVerifier() {
            
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] x509Certificates,
                    String s) throws java.security.cert.CertificateException {
            }

            
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] x509Certificates,
                    String s) throws java.security.cert.CertificateException {
            }

            
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
            }
        } };
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            client.setSslSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mInstance = new Picasso.Builder(context)
                .downloader(new OkHttpDownloader(client))
                .listener(new Picasso.Listener() {
                    
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        Log.e("PICASSO", exception);
                    }
                }).build();

    }

    public static Picasso getInstance(Context context) {
        if (mInstance == null) {
             new PicassoTrustAll(context);
        }
        return mInstance;
    }
}

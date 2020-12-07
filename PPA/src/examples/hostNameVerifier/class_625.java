package examples.hostNameVerifier; 
public class class_625 { 
try {
        TrustManager[] victimizedManager = new TrustManager[]{

                new X509TrustManager() {

                    public X509Certificate[] getAcceptedIssuers() {

                        X509Certificate[] myTrustedAnchors = new X509Certificate[0];

                        return myTrustedAnchors;
                    }

                    
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, victimizedManager, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });
    } catch (Exception e) {
        e.printStackTrace();
    }

}
package examples.AllCodeSnippets; 
public class class_624{ 
 public static void main() { 
try {
        TrustManager[] victimizedManager = new TrustManager[]{

                new X509TrustManager() {

                    public X509Certificate[] getAcceptedIssuers() {

                        X509Certificate[] myTrustedAnchors = new X509Certificate[0];

                        return myTrustedAnchors;
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, victimizedManager, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}

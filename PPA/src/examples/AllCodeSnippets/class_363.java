package examples.AllCodeSnippets; 
public class class_363{ 
 public static void main() { 
private static SSLSocketFactory createSslSocketFactory() {
    TrustManager[] byPassTrustManagers = new TrustManager[]{new X509TrustManager() {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }
    }};

    SSLContext sslContext = null;
    SSLSocketFactory sslSocketFactory = null;
    try {
        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, byPassTrustManagers, new SecureRandom());
        sslSocketFactory = sslContext.getSocketFactory();

    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        Log.e(TAG, StringUtils.EMPTY, e);
    } catch (KeyManagementException e) {
        Log.e(TAG, StringUtils.EMPTY, e);
    }

    return sslSocketFactory;
}
  }
}

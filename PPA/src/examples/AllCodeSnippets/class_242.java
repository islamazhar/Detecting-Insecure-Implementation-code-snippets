package examples.AllCodeSnippets; 
public class class_242{ 
 public static void main() { 
private static void trustAllHosts()
{
    // Create a trust manager that does not validate certificate chains
    TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager()
    {
        public java.security.cert.X509Certificate[] getAcceptedIssuers()
        {
            return new java.security.cert.X509Certificate[] {};
        }

        public void checkClientTrusted(X509Certificate[] chain,
                String authType) throws CertificateException
        {}

        public void checkServerTrusted(X509Certificate[] chain,
                String authType) throws CertificateException
        {}
    }

    // Install the all-trusting trust manager
    try
    {
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection
        .setDefaultSSLSocketFactory(sc.getSocketFactory());
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}
  }
}

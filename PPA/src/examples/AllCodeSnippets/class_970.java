package examples.AllCodeSnippets; 
public class class_970{ 
 public static void main() { 
        public void checkClientTrusted(X509Certificate[] chain,
                String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain,
                String authType) throws CertificateException {
        }
    } };

    // Install the all-trusting trust manager
    try {
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection
                .setDefaultSSLSocketFactory(sc.getSocketFactory());
    } catch (Exception e) {
        e.printStackTrace();
    }
}



final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
};
  }
}

package test.ppa;

public class B {
      TrustManager[] tm = new TrustManager[] { 
          new X509TrustManager() {
          public void checkClientTrusted(X509Certificate[] chain,
            String authType) throws CertificateException {
            // do nothing empty implementation acceding all certes 
            //  including self signed and forged certs

          }

        public void checkServerTrusted(X509Certificate[] chain,
            String authType) throws CertificateException {
            // do nothing
        }
      } 
    };
}

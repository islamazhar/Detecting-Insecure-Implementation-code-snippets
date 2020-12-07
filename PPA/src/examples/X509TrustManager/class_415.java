package examples.X509TrustManager; 
public class class_415 { 
HttpsURLConnection.setDefaultHostnameVerifier(new NullHostNameVerifier());
        try {
            SSLContext context = SSLContext.getInstance("TLS");
            TrustManager[] tm = new TrustManager[] {
                    new X509TrustManager() {

                        
                        public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws java.security.cert.CertificateException {
                            // not implemented
                        }

                        
                        public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws java.security.cert.CertificateException {
                            // not implemented
                        }

                        
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                    }
            };
            HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());

        }catch(Exception e){}

}
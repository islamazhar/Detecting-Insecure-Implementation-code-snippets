package examples.AllCodeSnippets; 
public class class_498{ 
 public static void main() { 
 CertificateFactory cf = CertificateFactory.getInstance("X.509");
            InputStream caInput = new BufferedInputStream(cafile);
            Certificate ca = null;
            try {
                ca = cf.generateCertificate(caInput);

            } catch(Exception e) {

            }
            finally {
                caInput.close();
            }
            certManagerCA.trustCertificate((X509Certificate) ca);
            KeyStore keyStoreCA = certManagerCA.sslKeystore;
            tmf = TrustManagerFactory.getInstance("X509");
            tmf.init(keyStoreCA);
  }
}

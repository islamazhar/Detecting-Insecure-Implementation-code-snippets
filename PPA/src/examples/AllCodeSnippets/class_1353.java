package examples.AllCodeSnippets; 
public class class_1353{ 
 public static void main() { 
                keyStore.load(byteArrayInputStream, keyStorePassword);
                Certificate[] certificates = keyStore.getCertificateChain("key-alias"); //you need to know the alias
                if(certificates.length > 0) {
                    Certificate certificate = certificates[0];
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    Log.d(TAG,
                          "Certificate found with DN [" + x509Certificate.getSubjectDN() + "]");
  }
}

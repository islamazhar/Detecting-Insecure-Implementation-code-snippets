package examples.AllCodeSnippets; 
public class class_791{ 
 public static void main() { 
private void getCertsFromP12(String pathToFile, String passphrase){
  try {
        KeyStore p12 = KeyStore.getInstance("pkcs12");
        p12.load(new FileInputStream(pathToFile), passphrase.toCharArray());
        Enumeration e = p12.aliases();
        while (e.hasMoreElements()) {
            String alias = (String) e.nextElement();
            X509Certificate c = (X509Certificate) p12.getCertificate(alias);
            addCertificateToKeyStore(c);
        }
    } catch (Exception e) {}
}

private void addCertificateToKeyStore(X509Certificate c) {
    try {
        KeyStore ks = KeyStore.getInstance("AndroidKeyStore");
        ks.load(null);
        ks.setCertificateEntry("myCertAlias", c);
    } catch (Exception e){}
}
  }
}

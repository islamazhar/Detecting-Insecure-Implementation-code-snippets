package examples.AllCodeSnippets; 
public class class_860{ 
 public static void main() { 
  private KeyStore loadPEMKeystoreStore(File certificateFile, String password) throws Exception {
        InputStream caInput = new BufferedInputStream(new FileInputStream(certificateFile));


        KeyStore keystore = KeyStore.getInstance(CLIENT_CERTIFICATE_KEYSTORE_TYPE);


        CertificateFactory certificateFactory = CertificateFactory
                .getInstance(X509);
        X509Certificate cert = (X509Certificate) certificateFactory
                .generateCertificate(caInput);


        keystore.load(null);
        keystore.setCertificateEntry("cert-alias", cert);
        keystore.setKeyEntry("key-alias", privateKey, password.toCharArray(),
                new Certificate[]{cert});
        FileOutputStream out = new FileOutputStream(file);
        keystore.store(out, password.toCharArray());

        return keyStore ;
    }
  }
}

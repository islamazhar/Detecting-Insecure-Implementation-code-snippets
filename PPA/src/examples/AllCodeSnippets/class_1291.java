package examples.AllCodeSnippets; 
public class class_1291{ 
 public static void main() { 
// Trust manager / truststore
KeyStore trustStore=KeyStore.getInstance(KeyStore.getDefaultType());

// If we're on an OS version prior to Ice Cream Sandwich (4.0) then use the standard way to get the system
//   trustStore -- System.getProperty() else we need to use the special name to get the trustStore KeyStore
//   instance as they changed their trustStore implementation.
if (Build.VERSION.RELEASE.compareTo("4.0") < 0) {
    TrustManagerFactory trustManagerFactory=TrustManagerFactory
        .getInstance(TrustManagerFactory.getDefaultAlgorithm());
    FileInputStream trustStoreStream=new FileInputStream(System.getProperty("javax.net.ssl.trustStore"));
    trustStore.load(trustStoreStream, null);
    trustManagerFactory.init(trustStore);
    trustStoreStream.close();
} else {
    trustStore=KeyStore.getInstance("AndroidCAStore");
}

InputStream certificateStream=new FileInputStream(userCertFile);
KeyStore keyStore=KeyStore.getInstance("PKCS12");
try {
    keyStore.load(certificateStream, certPass.toCharArray());
    Enumeration<String> aliases=keyStore.aliases();
    while (aliases.hasMoreElements()) {
        String alias=aliases.nextElement();
        if (keyStore.getCertificate(alias).getType().equals("X.509")) {
            X509Certificate cert=(X509Certificate)keyStore.getCertificate(alias);
            if (new Date().after(cert.getNotAfter())) {
                // This certificate has expired
                return;
            }
        }
    }
} catch (IOException ioe) {
    // This occurs when there is an incorrect password for the certificate
    return;
} finally {
    certificateStream.close();
}

KeyManagerFactory keyManagerFactory=KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
keyManagerFactory.init(keyStore, certPass.toCharArray());

socketFactory=new SSLSocketFactory(keyStore, certPass, trustStore);
  }
}

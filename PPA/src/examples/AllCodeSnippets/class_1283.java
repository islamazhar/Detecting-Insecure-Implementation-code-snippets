package examples.AllCodeSnippets; 
public class class_1283{ 
 public static void main() { 
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

// Some of these exist in more than one package, be careful to include these
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

// This would reference to your KeyStore to store the certificate
KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
ks.load(null);             // This will make a new store
// In the next line, specify the file path
// You can also export the destination certificate (in your case, Paypal's)
// put it as a hardcoded `String` and work with it.
InputStream is = ...;
BufferedInputStream bis = new BufferedInputStream(is);

CertificateFactory cf = CertificateFactory.getInstance("X.509");

while (bis.available() > 0) {
  Certificate cert = cf.generateCertificate(bis);
  trustStore.setCertificateEntry("myAlias" + bis.available(), cert);
}
  }
}

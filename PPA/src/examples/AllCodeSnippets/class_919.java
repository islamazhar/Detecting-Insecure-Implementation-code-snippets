package examples.AllCodeSnippets; 
public class class_919{ 
 public static void main() { 
byte[] certData = ...       
/* create KeyStore */
KeyStore ks = KeyStore.getInstance("JKS", "SUN");
/* load key store (initialization */
ks.load(null, null);
/* create CertificateFactory */
CertificateFactory cf = CertificateFactory.getInstance("X509");
/* create certificate from input stream */
Certificate cert;
/* provide cert data */
ByteArrayInputStream in = new ByteArrayInputStream(makeCert(certData));



private static byte[] makeCert(byte[] data) {
    String headline = "-----BEGIN CERTIFICATE-----";
    String footline = "-----END CERTIFICATE-----";

    String certStr = headline;
    for (int i = 0; i < data.length; i++) {
        if (i%64 == 0) {
            certStr += "\n";
        }
        certStr += (char)data[i];
    }
    if ((data.length-1)%64 != 0) {
        certStr += "\n";
    }
    certStr += footline;
    return certStr.getBytes();
}
  }
}

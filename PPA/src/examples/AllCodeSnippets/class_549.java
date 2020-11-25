package examples.AllCodeSnippets; 
public class class_549{ 
 public static void main() { 
public X509Certificate[] getAcceptedIssuers()
{
    X509Certificate[] trustedAnchors =
        super.getAcceptedIssuers();

    /* Create a new array with room for an additional trusted certificate. */
    X509Certificate[] myTrustedAnchors = new X509Certificate[trustedAnchors.length + 1];
    System.arraycopy(trustedAnchors, 0, myTrustedAnchors, 0, trustedAnchors.length);  

    /* Load your certificate.

       Thanks to http://stackoverflow.com/questions/11857417/x509trustmanager-override-without-allowing-all-certs
       for this bit.
     */
    InputStream inStream = new FileInputStream("fileName-of-cert");
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    X509Certificate cert = (X509Certificate)cf.generateCertificate(inStream);
    inStream.close();

    /* Add your anchor cert as the last item in the array. */
    myTrustedAnchors[trustedAnchors.length] = cert;

    return myTrustedAnchors;
}
  }
}

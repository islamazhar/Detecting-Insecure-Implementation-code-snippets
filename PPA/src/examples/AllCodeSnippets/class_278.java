package examples.AllCodeSnippets; 
public class class_278{ 
 public static void main() { 
CertificateFactory cf = CertificateFactory.getInstance("X.509");
    // From https://www.washington.edu/itconnect/security/ca/load-der.crt
    InputStream is = context.getResources().getAssets().openAsset("somefolder/somecertificate.crt"); // path should be your files path
    InputStream caInput = new BufferedInputStream(is);
    Certificate ca;
    try {
        ca = cf.generateCertificate(caInput);
        // System.out.println("ca=" + ((X509Certificate) ca).getSubjectDN());
    } finally {
        caInput.close();
    }
  }
}

package examples.AllCodeSnippets; 
public class class_457{ 
 public static void main() { 
    try {
        PackageInfo pi = this.getPackageManager().getPackageInfo( this.getPackageName(), PackageManager.GET_SIGNATURES);
        Signature[] signatures = pi.signatures;
        byte[] cert = signatures[0].toByteArray();
        InputStream input = new ByteArrayInputStream(cert);
        CertificateFactory cf = CertificateFactory.getInstance("X509");
        X509Certificate cf509 = (X509Certificate) cf.generateCertificate(input);
        Log.d(LOG_TAG, "Certificate issued by: " + cf509.getIssuerDN() );
    } catch ( Exception e ) {
  }
}

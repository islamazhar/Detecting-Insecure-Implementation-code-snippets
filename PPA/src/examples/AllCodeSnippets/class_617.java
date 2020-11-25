package examples.AllCodeSnippets; 
public class class_617{ 
 public static void main() { 
private static final X500Principal DEBUG_DN = new X500Principal("CN=Android Debug,O=Android,C=US");
/* ... */
Signature raw = packageManager.getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES).signatures[0];
CertificateFactory cf = CertificateFactory.getInstance("X.509");
X509Certificate cert = (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(raw.toByteArray()));
boolean debug = cert.getSubjectX500Principal().equals(DEBUG_DN);
  }
}

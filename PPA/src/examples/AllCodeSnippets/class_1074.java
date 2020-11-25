package examples.AllCodeSnippets; 
public class class_1074{ 
 public static void main() { 
PackageManager pm = context.getPackageManager();
Signature sig = packageManager.getPackageInfo(getPackageName(), 
   PackageManager.GET_SIGNATURES).signatures[0];
CertificateFactory cf = CertificateFactory.getInstance("X.509");
X509Certificate cert = (X509Certificate) cf.generateCertificate(
    new ByteArrayInputStream(sig.toByteArray()));
String dn = cert.getIssuerDN().getName();
  }
}

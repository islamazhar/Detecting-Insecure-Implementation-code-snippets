package examples.AllCodeSnippets; 
public class class_1207{ 
 public static void main() { 
try {
    PackageInfo info = getPackageManager().getPackageInfo(pkgName, PackageManager.GET_SIGNATURES);
    Signature[] sigs = info.signatures;
    for (Signature sig : sigs) {
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream in = new ByteArrayInputStream(sig.toByteArray());
        X509Certificate cert = (X509Certificate) certFactory.generateCertificate(in);
        // Verify or inspect cert here
    }
} catch (...) {
    //...
}
  }
}

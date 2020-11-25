package examples.AllCodeSnippets; 
public class class_188{ 
 public static void main() { 
final PackageManager packageManager = context.getPackageManager();
final List<PackageInfo> packageList = packageManager.getInstalledPackages(PackageManager.GET_SIGNATURES);
CertificateFactory certFactory = null;
try {
    certFactory = CertificateFactory.getInstance("X509");
}
catch (CertificateException e) {
    // e.printStackTrace();
}

for (PackageInfo p : packageList) {
    String strName = p.applicationInfo.loadLabel(packageManager).toString();
    String strVendor = p.packageName;

    sb.append("<br>" + strName + " / " + strVendor + "<br>");

    Signature[] arrSignatures = p.signatures;
    for (Signature sig : arrSignatures) {
        /*
        * Get the X.509 certificate.
        */
        byte[] rawCert = sig.toByteArray();
        InputStream certStream = new ByteArrayInputStream(rawCert);

        X509Certificate x509Cert = null;
        try {
            x509Cert = (X509Certificate) certFactory.generateCertificate(certStream);
        }
        catch (CertificateException e) {
            // e.printStackTrace();
        }

        sb.append("Certificate subject: " + x509Cert.getSubjectDN() + "<br>");
        sb.append("Certificate issuer: " + x509Cert.getIssuerDN() + "<br>");
        sb.append("Certificate serial number: " + x509Cert.getSerialNumber() + "<br>");
        sb.append("<br>");
    }
}
  }
}

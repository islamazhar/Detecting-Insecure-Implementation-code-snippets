package examples.AllCodeSnippets; 
public class class_301{ 
 public static void main() { 
public void validateCertificate() throws Exception {
    try {
        String issuerCertPath = "Issuer Certifate";
        String certPath = "Issued Certificate";
        X509Certificate issuerCert = getCertFromFile(issuerCertPath);
        X509Certificate c1 = getCertFromFile(certPath);
        TrustAnchor anchor = new TrustAnchor(issuerCert, null);
        Set anchors = Collections.singleton(anchor);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        List list = Arrays.asList(new Certificate[] { c1 });
        CertPath path = cf.generateCertPath(list);
        PKIXParameters params = new PKIXParameters(anchors);
        params.setRevocationEnabled(false);
        CertPathValidator validator = CertPathValidator.getInstance("PKIX");
        PKIXCertPathValidatorResult result = (PKIXCertPathValidatorResult) validator
                .validate(path, params);
        // If
        // not
        // valid
        // will
        // throw
        System.out.println("VALID");
    } catch (Exception e) {
        System.out.println("EXCEPTION " + e.getMessage());
        e.printStackTrace();
    }
}

private X509Certificate getCertFromFile(String path) throws Exception {
    AssetManager assetManager = MyActivity.this.getResources().getAssets();
    InputStream inputStream = null;
    try {
        inputStream = assetManager.open(path);
    } catch (IOException e) {
        e.printStackTrace();
    }
    InputStream caInput = new BufferedInputStream(inputStream);
    X509Certificate cert = null;
    CertificateFactory cf = CertificateFactory.getInstance("X509");
    cert = (X509Certificate) cf.generateCertificate(caInput);
    cert.getSerialNumber();
    return cert;
}
  }
}

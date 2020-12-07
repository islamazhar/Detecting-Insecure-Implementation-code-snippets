package examples.RSA; 
public class class_83 { 
private enum BuildSigner {
    unknown,
    Joe,
    Carl,
    Linda
}

private BuildSigner whoBuiltThis() {
    try {
        PackageManager packageManager = getPackageManager();
        PackageInfo info = packageManager.getPackageInfo(getPackageName(),
                PackageManager.GET_SIGNATURES);
        Signature[] signs = info.signatures;
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate cert = (X509Certificate)cf.generateCertificate(
                new ByteArrayInputStream(signs[0].toByteArray()));
        PublicKey key = cert.getPublicKey();
        int modulusHash = ((RSAPublicKey)key).getModulus().hashCode();
        switch (modulusHash) {
            case 123456789:
                return BuildSigner.Joe;
            case 424242424:
                return BuildSigner.Carl;
            case -975318462:
                return BuildSigner.Linda;
        }
    } catch (Exception e) {
    }

    return BuildSigner.unknown;
}

}
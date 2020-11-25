package examples.AllCodeSnippets; 
public class class_1102{ 
 public static void main() { 
public X509Certificate parseCertificate(String certificate) throws CertificateException {
    byte[] decoded = Base64.decode(certificate.replaceAll("-----BEGIN CERTIFICATE-----", ").replaceAll("-----END CERTIFICATE-----", "));
    return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(decoded));
}
  }
}

package examples.RSA; 
public class class_632 { 
InputStream in = new FileInputStream("CERT.RSA");
CertificateFactory factory = CertificateFactory.getInstance("X.509")
X509Certificate cert = (X509Certificate) factory.generateCertificate(in);

}
package examples.AllCodeSnippets; 
public class class_1203{ 
 public static void main() { 
CertificateFactory factory = CertificateFactory.getInstance("X.509");
X509Certificate x509Server;
ByteArrayInputStream bias = new ByteArrayInputStream(certBytes);
x509Server= (X509Certificate) factory.generateCertificate(bias);
  }
}

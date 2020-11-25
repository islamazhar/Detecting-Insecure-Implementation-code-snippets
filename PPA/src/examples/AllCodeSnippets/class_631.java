package examples.AllCodeSnippets; 
public class class_631{ 
 public static void main() { 
InputStream in = new FileInputStream("CERT.RSA");
CertificateFactory factory = CertificateFactory.getInstance("X.509")
X509Certificate cert = (X509Certificate) factory.generateCertificate(in);
  }
}

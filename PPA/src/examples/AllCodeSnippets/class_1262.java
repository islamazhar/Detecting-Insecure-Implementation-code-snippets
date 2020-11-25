package examples.AllCodeSnippets; 
public class class_1262{ 
 public static void main() { 
CertificateFactory cf = CertificateFactory.getInstance("X.509");
// From https://www.washington.edu/itconnect/security/ca/load-der.crt

InputStream caInput = new BufferedInputStream(new FileInputStream("load-   der.crt"));
Certificate ca;
try {
ca = cf.generateCertificate(caInput);
System.out.println("ca=" + ((X509Certificate) ca).getSubjectDN());
} finally {
caInput.close();
}
  }
}

package examples.AllCodeSnippets; 
public class class_582{ 
 public static void main() { 
FileInputStream fis = new FileInputStream(filename);
BufferedInputStream bis = new BufferedInputStream(fis);

CertificateFactory cf = CertificateFactory.getInstance("X.509");
Certificate cert = cf.generateCertificate(bis);
  }
}

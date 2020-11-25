package examples.AllCodeSnippets; 
public class class_632{ 
 public static void main() { 
FileReader fileReader = new FileReader("/path/to/cert.pem");
PEMReader pemReader = new PEMReader(fileReader);
Object obj = pemReader.readObject();
pemReader.close(); // sloppy IO handling, be thorough in production code
X509CertificateObject certObj = (X509CertificateObject) obj;
System.out.println(certObj.getPublicKey());
  }
}

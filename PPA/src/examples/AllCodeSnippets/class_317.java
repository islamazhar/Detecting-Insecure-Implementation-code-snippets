package examples.AllCodeSnippets; 
public class class_317{ 
 public static void main() { 
public X509Certificate x509ReqToX509(PKCS10CertificationRequest csr, int days, PrivateKey pKey) 
{
  Date notBefore = new Date();
  Calendar cal = Calendar.getInstance();
  cal.add(Calendar.DATE, days);
  Date notAfter = cal.getTime();
  BigInteger serialNumber = generateCertSerialNumber(); // No implemented here

  X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();

  certGen.setSerialNumber(serialNumber);
  certGen.setIssuerDN(csr.getCertificationRequestInfo().getSubject());
  certGen.setSubjectDN(csr.getCertificationRequestInfo().getSubject());
  certGen.setNotBefore(notBefore);
  certGen.setNotAfter(notAfter);
  certGen.setPublicKey(csr.getPublicKey());
  certGen.setSignatureAlgorithm("SHA256WithRSAEncryption");

  return certGen.generate(pKey, "BC");
}
  }
}

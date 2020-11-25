package examples.AllCodeSnippets; 
public class class_1282{ 
 public static void main() { 
PackageInfo packageInfo = null;

try {
   packageInfo = getPackageManager().getPackageInfo(getPackageName(), 
                                           PackageManager.GET_SIGNATURES);

   Signature[] signatures = packageInfo.signatures;
   byte[] cert = signatures[0].toByteArray();
   InputStream input = new ByteArrayInputStream(cert);

   CertificateFactory cf = CertificateFactory.getInstance("X509");
   X509Certificate c = (X509Certificate)cf.generateCertificate(input);

   PublicKey key = c.getPublicKey();

   ...   

} catch ( Exception e) {
        e.printStackTrace();
}
  }
}

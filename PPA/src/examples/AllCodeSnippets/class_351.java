package examples.AllCodeSnippets; 
public class class_351{ 
 public static void main() { 
  private X509Certificate getCertFromFile(String path) throws Exception {
     AssetManager assetManager = MyActivity.this.getResources().getAssets();
     InputStream inputStream = null;
     try {
         inputStream = assetManager.open(path);
     } catch (IOException e) {
         e.printStackTrace();
     }
     InputStream caInput = new BufferedInputStream(inputStream);
     X509Certificate cert = null;
     CertificateFactory cf = CertificateFactory.getInstance("X509");
     cert = (X509Certificate) cf.generateCertificate(caInput);
     cert.getSerialNumber();
     return cert;
  }
  }
}

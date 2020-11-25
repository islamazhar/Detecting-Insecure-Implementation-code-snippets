package examples.AllCodeSnippets; 
public class class_656{ 
 public static void main() { 
CertificateFactory cf = CertificateFactory.getInstance("X.509");
AssetManager assetManager = getAssets();
InputStream caInput = new BufferedInputStream(assetManager.open("your_cert.cer"));
Certificate ca = cf.generateCertificate(caInput);

AndroidHttpTransport androidHttpTransport = new AndroidHttpTransport(ca, url);
  }
}

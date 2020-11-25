package examples.AllCodeSnippets; 
public class class_1101{ 
 public static void main() { 
// read .crt file from memory
InputStream inStream = ctx.openFileInput("cetificate.crt");

//InputStream inStream = ctx.getAssets().open("wm_loaner.cer");
if(inStream != null)
{
    KeyStore cert = CertUtils.ConvertCerToBKS(inStream, "MyAlias", "password".toCharArray());
    inStream.close();
}

public static KeyStore ConvertCerToBKS(InputStream cerStream, String alias, char [] password)
{
    KeyStore keyStore = null;
    try
    {
        keyStore = KeyStore.getInstance("BKS", "BC");
        CertificateFactory factory = CertificateFactory.getInstance("X.509", "BC");
        Certificate certificate = factory.generateCertificate(cerStream);
        keyStore.load(null, password);
        keyStore.setCertificateEntry(alias, certificate);
    }
    catch ....
    {
    }
    return keyStore;                                    
}
  }
}

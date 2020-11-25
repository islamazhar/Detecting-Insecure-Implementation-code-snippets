package examples.AllCodeSnippets; 
public class class_609{ 
 public static void main() { 
private static final X500Principal DEBUG_DN = new X500Principal("CN=Android Debug,O=Android,C=US");
private boolean isDebuggable(Context ctx)
{
    boolean debuggable = false;

    try
    {
        PackageInfo pinfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(),PackageManager.GET_SIGNATURES);
        Signature signatures[] = pinfo.signatures;

        CertificateFactory cf = CertificateFactory.getInstance("X.509");

        for ( int i = 0; i < signatures.length;i++)
        {   
            ByteArrayInputStream stream = new ByteArrayInputStream(signatures[i].toByteArray());
            X509Certificate cert = (X509Certificate) cf.generateCertificate(stream);       
            debuggable = cert.getSubjectX500Principal().equals(DEBUG_DN);
            if (debuggable)
                break;
        }
    }
    catch (NameNotFoundException e)
    {
        //debuggable variable will remain false
    }
    catch (CertificateException e)
    {
        //debuggable variable will remain false
    }
    return debuggable;
}
  }
}

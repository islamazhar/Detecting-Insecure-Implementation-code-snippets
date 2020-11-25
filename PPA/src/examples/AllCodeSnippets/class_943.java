package examples.AllCodeSnippets; 
public class class_943{ 
 public static void main() { 
        static public boolean DEVELOPMENT_VERBOSE = false;
        static private final  X500Principal RELEASE_DN = new X500Principal(
            "CN=aaa,OU=bbb,O=ccc,L=ddd,ST=eee,C=fff"
            );

        // auto disable the development logs if the apk is signed with a cert
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo appInfo = manager.getPackageInfo("com.xxx.app",
                    PackageManager.GET_SIGNATURES);
            Signature raw = appInfo.signatures[0];

            try {
                CertificateFactory cf = CertificateFactory.getInstance("X.509");
                X509Certificate cert = (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(raw.toByteArray()));

                //DEVELOPMENT_VERBOSE = cert.getSubjectX500Principal().equals(DEBUG_DN);
                if (!cert.getSubjectX500Principal().equals(RELEASE_DN))
                    DEVELOPMENT_VERBOSE = true;

            } catch (CertificateException e) {  

            }           
        } catch (NameNotFoundException e) {

        }
  }
}

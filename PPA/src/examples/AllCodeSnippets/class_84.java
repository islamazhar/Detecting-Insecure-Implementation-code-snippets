package examples.AllCodeSnippets; 
public class class_84{ 
 public static void main() { 
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    int hash = 0;
    try{
        PackageManager packageManager = getPackageManager();
        PackageInfo info = packageManager.getPackageInfo(
                "com.stackexchange.marvin", PackageManager.GET_SIGNATURES);
        Signature[] signs = info.signatures;
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate cert = (X509Certificate) cf.generateCertificate(
                new ByteArrayInputStream(signs[0].toByteArray()));
        PublicKey key = cert.getPublicKey();
        hash = ((RSAPublicKey) key).getModulus().hashCode();
    }catch(Exception e){}

    TextView tv = ((TextView)findViewById(R.id.tv));
    tv.setText("The Stack Exchange app's signature hash is " + hash + ".");
    tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
}
  }
}

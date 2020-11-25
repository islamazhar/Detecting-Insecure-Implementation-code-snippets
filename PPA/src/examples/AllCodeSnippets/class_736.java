package examples.AllCodeSnippets; 
public class class_736{ 
 public static void main() { 
KeyStore ks = KeyStore.getInstance("AndroidCAStore");
ks.load(null, null);
Enumeration aliases = ks.aliases();
while (aliases.hasMoreElements()) {
    String alias = aliases.nextElement();
    X509Certificate cert = (X509Certificate) 
       ks.getCertificate(alias);
    Log.d(TAG, "Subject DN: " + 
       cert.getSubjectDN().getName());
    Log.d(TAG, "Subject SN: " + 
       cert.getSerialNumber().toString());
    Log.d(TAG, "Issuer DN: " + 
       cert.getIssuerDN().getName());
}
  }
}

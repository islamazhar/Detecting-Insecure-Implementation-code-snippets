package examples.AllCodeSnippets; 
public class class_200{ 
 public static void main() { 
public boolean checkCACertificateInstalled(javax.security.cert.X509Certificate x509){

    boolean isCACertificateInstalled = false;

    try 
    {
        String name = x509.getIssuerDN().getName(); 
        KeyStore ks = KeyStore.getInstance("AndroidCAStore");
        if (ks != null) 
        {
            ks.load(null, null);
            Enumeration<String> aliases = ks.aliases();
            while (aliases.hasMoreElements()) 
            {
                String alias = (String) aliases.nextElement();
                java.security.cert.X509Certificate cert = (java.security.cert.X509Certificate) ks.getCertificate(alias);

                if (cert.getIssuerDN().getName().contains(name)) 
                {
                    isCACertificateInstalled = true;
                    break;
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    } catch (KeyStoreException e) {
        e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (java.security.cert.CertificateException e) {
        e.printStackTrace();
    }

    return isCACertificateInstalled;
}
  }
}

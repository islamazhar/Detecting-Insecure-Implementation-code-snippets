package examples.AllCodeSnippets; 
public class class_80{ 
 public static void main() { 
try 
    {
        KeyStore ks = KeyStore.getInstance("AndroidCAStore");
        if (ks != null) 
        {
            ks.load(null, null);
            Enumeration aliases = ks.aliases();
            while (aliases.hasMoreElements()) 
            {
                String alias = (String) aliases.nextElement();
                java.security.cert.X509Certificate cert = (java.security.cert.X509Certificate) ks.getCertificate(alias);

                Log.d(LOG_TAG, cert.getIssuerDN().getName());
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
  }
}

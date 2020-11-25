package examples.AllCodeSnippets; 
public class class_467{ 
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

                    if (cert.getIssuerDN().getName().contains("MyCert")) 
                    {
                        isCertExist = true;
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
  }
}

package examples.AllCodeSnippets; 
public class class_281{ 
 public static void main() { 
public void PrintInstalledCertificates( ){

               try 
                {
                    KeyStore ks = KeyStore.getInstance("AndroidCAStore");
                    if (ks != null) 
                    {
                        ks.load(null, null);
                        Enumeration<String> aliases = ks.aliases();
                        while (aliases.hasMoreElements()) 
                        {
                            String alias = (String) aliases.nextElement();
                            java.security.cert.X509Certificate cert = (java.security.cert.X509Certificate) ks.getCertificate(alias);
                                        //To print System Certs only
                                        if(cert.getIssuerDN().getName().contains(âsystemâ)){
                                         System.out.println(cert.getIssuerDN().getName());
                                        }

                                        //To print User Certs only 
                                        if(cert.getIssuerDN().getName().contains(âuserâ)){
                                         System.out.println(cert.getIssuerDN().getName());
                                        }

                                        //To print all certs
                            System.out.println(cert.getIssuerDN().getName());                           
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
}

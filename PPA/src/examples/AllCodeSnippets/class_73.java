package examples.AllCodeSnippets; 
public class class_73{ 
 public static void main() { 
try {

        File file = new File(keystore location);
        is = new FileInputStream(file);
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        String password = "password";
        keystore.load(is, password.toCharArray());


        Enumeration enumeration = keystore.aliases();
        while(enumeration.hasMoreElements()) {
            String alias = (String)enumeration.nextElement();
            System.out.println("alias name: " + alias);
            Certificate certificate = keystore.getCertificate(alias);
            System.out.println(certificate.toString());

        }

    } catch (java.security.cert.CertificateException e) {
        e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (KeyStoreException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }finally {
        if(null != is)
            try {
                is.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
  }
}

package examples.AllCodeSnippets; 
public class class_931{ 
 public static void main() { 
private SSLSocketFactory getSocketFactory() {
        // TODO Auto-generated method stub
        SSLSocketFactory sslFactory = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("BKS");
            InputStream instream = this.getResources().openRawResource(
                    R.raw.website_public);
            keyStore.load(instream, "keystore_password".toCharArray());
            sslFactory = new MySSLSocketFactory(keyStore);
        } catch (KeyStoreException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (NoSuchAlgorithmException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (CertificateException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (UnrecoverableKeyException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (KeyManagementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sslFactory;
    }
  }
}

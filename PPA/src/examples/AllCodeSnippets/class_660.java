package examples.AllCodeSnippets; 
public class class_660{ 
 public static void main() { 
private boolean ValidateHTTPSCertificate()
    {
        boolean result = false;
        String serverCertPublicSerial = "abcdefghijklmnopqrstuvwxyz";

        try
        {
            URL url = new URL( "https://your-url-goes-here" );
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            if(con!=null){

                try {
                    con.connect();

                    int respCode =  con.getResponseCode();
                    String pageResult = convertInputStreamToString(con.getInputStream());

                    Certificate[] certs = con.getServerCertificates();
                    for(Certificate cert : certs){

                        X509Certificate x509cert = (X509Certificate)cert;

                        BigInteger serialNum = x509cert.getSerialNumber();

                        String name = x509cert.getIssuerDN().getName();
                        String publicKeySerial = serialNum.toString(16);

                        if (publicKeySerial.toLowerCase().equals(serverCertPublicSerial.toLowerCase()) == true )
                        {
                            result = true;
                            break;
                        }
                    }
                    //con.disconnect();
                } catch (SSLPeerUnverifiedException e) {
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        catch (Exception ex)
        {
            String  msg = ex.getMessage();
        }

        return result;
    }
  }
}

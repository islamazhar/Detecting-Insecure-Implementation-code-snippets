package examples.hostNameVerifier; 
public class class_622 { 
client.setHostnameVerifier(new HostnameVerifier() {
            
            public boolean verify(String hostname, SSLSession session) {
                //return true;
                HostnameVerifier hv =
                        HttpsURLConnection.getDefaultHostnameVerifier();
                return hv.verify("ipage.com", session);
            }
        });

}
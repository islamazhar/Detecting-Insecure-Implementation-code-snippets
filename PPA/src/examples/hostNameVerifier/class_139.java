package examples.hostNameVerifier; 
public class class_139 { 
OkHttpClient client = new OkHttpClient();
client.setHostnameVerifier(new HostnameVerifier() {
            
            public boolean verify(String hostname, SSLSession session) {
                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                    System.out.println("Warning: URL host '" + urlHostName
                            + "' is different to SSLSession host '"
                            + session.getPeerHost() + "'.");
                }
                return true;
            }
        });

}
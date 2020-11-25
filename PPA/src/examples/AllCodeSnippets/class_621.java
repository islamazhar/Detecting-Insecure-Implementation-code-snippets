package examples.AllCodeSnippets; 
public class class_621{ 
 public static void main() { 
client.setHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                //return true;
                HostnameVerifier hv =
                        HttpsURLConnection.getDefaultHostnameVerifier();
                return hv.verify("ipage.com", session);
            }
        });
  }
}

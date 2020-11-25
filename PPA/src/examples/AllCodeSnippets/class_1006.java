package examples.AllCodeSnippets; 
public class class_1006{ 
 public static void main() { 
     HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
     urlConnection.setSSLSocketFactory(getSSLSocketFactory());
     urlConnection.setHostnameVerifier(new HostnameVerifier() {
               @Override
                    public boolean verify(String hostname, SSLSession session) {
                        HostnameVerifier hv = HttpsURLConnection.getDefaultHostnameVerifier();
                        return hv.verify("localhost", session);
                    }
                });
  }
}

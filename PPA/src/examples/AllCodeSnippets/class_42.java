package examples.AllCodeSnippets; 
public class class_42{ 
 public static void main() { 
HostnameVerifier hostnameVerifier = new HostnameVerifier() {
    @Override
    public boolean verify(String hostname, SSLSession session) {
        HostnameVerifier hv =
            HttpsURLConnection.getDefaultHostnameVerifier();
        return hv.verify("localhost", session);
    }
};
  }
}

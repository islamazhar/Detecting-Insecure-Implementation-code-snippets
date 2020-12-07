package examples.hostNameVerifier; 
public class class_42 { 
HostnameVerifier hostnameVerifier = new HostnameVerifier() {
    
    public boolean verify(String hostname, SSLSession session) {
        HostnameVerifier hv =
            HttpsURLConnection.getDefaultHostnameVerifier();
        return hv.verify("localhost", session);
    }
};

}
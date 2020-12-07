package examples.X509TrustManager; 
public class class_1258 { 
SSLContext sc = SSLContext.getInstance("TLS");
TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
    
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        return;
}
    
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        return;
    }
} };
sc.init(null, trustAllCerts, new SecureRandom());
HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
HttpURLConnection = connection = endPoint.openConnection();

}
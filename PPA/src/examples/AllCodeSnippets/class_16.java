package examples.AllCodeSnippets; 
public class class_16{ 
 public static void main() { 
public ServiceConnectionSE(Proxy proxy, String url) throws IOException {
    try {
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
     } catch (Exception e) {
        e.getMessage();
     }
     connection = (HttpsURLConnection) new URL(url).openConnection();
    ((HttpsURLConnection) connection).setHostnameVerifier(new AllowAllHostnameVerifier());

    connection.setUseCaches(false);
    connection.setDoOutput(true);
    connection.setDoInput(true);
}
  }
}

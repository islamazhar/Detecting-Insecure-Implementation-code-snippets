package examples.AllCodeSnippets; 
public class class_1355{ 
 public static void main() { 
SSLContext sslcontext = SSLContext.getInstance("TLSv1");

            sslcontext.init(null,
                    null,
                    null);
            SSLSocketFactory NoSSLv3Factory = new NoSSLv3SocketFactory(sslcontext.getSocketFactory());

            HttpsURLConnection.setDefaultSSLSocketFactory(NoSSLv3Factory);
            l_connection = (HttpsURLConnection) l_url.openConnection();
            l_connection.connect();
  }
}

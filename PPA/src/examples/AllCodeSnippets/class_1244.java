package examples.AllCodeSnippets; 
public class class_1244{ 
 public static void main() { 
 SSLContext sslContext = SSLContext.getInstance("TLSv1");
                sslContext.init(null, null, null);
                SSLSocketFactory socketFactory = sslContext.getSocketFactory();
                            httpURLConnection.setSSLSocketFactory(socketFactory);
  }
}

package examples.AllCodeSnippets; 
public class class_952{ 
 public static void main() { 
SSLContext context = SSLContext.getInstance("TLS");
    context.init(null, null, null);
    SSLSocketFactory factory = context.getSocketFactory();
    httpURLConnection.setSSLSocketFactory(factory);
  }
}

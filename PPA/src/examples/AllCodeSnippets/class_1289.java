package examples.AllCodeSnippets; 
public class class_1289{ 
 public static void main() { 
if(Build.VERSION.SDK_INT<16)
    sslContext = SSLContext.getInstance("TLS");
else
    sslContext = SSLContext.getInstance("TLSv1.2");
  }
}

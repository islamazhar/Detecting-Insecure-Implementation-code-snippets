package examples.AllCodeSnippets; 
public class class_99{ 
 public static void main() { 
public URLConnection getTolerantClient(URL url) throws IOException {
    URLConnection conn = url.openConnection();
    if (!(conn instanceof HttpsURLConnection)) {
        /* not an https:// URL, nothing to do */
        return conn;
    }
    HttpsURLConnection httpsconn = (HttpsURLConnection)conn;
    final HostnameVerifier delegate = httpsconn.getHostnameVerifier();
    if(!(delegate instanceof MyVerifier)) {
        httpsconn.setHostnameVerifier(new MyVerifier(delegate));
    }
    return conn;
}
  }
}

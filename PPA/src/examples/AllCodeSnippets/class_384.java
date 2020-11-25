package examples.AllCodeSnippets; 
public class class_384{ 
 public static void main() { 
    ...
    urlConnection = (HttpsURLConnection) url.openConnection();
    urlConnection.setSSLSocketFactory(new MySSLSocketFactory(urlConnection.getSSLSocketFactory()));
    ...
  }
}

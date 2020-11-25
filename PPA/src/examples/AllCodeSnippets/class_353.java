package examples.AllCodeSnippets; 
public class class_353{ 
 public static void main() { 
    boolean httpYes, httpsYes;
     try {

      URL url = new URL(weburi);
      urlConnection = (HttpURLConnection) url.openConnection();
      inputStream = new BufferedInputStream((urlConnection.getInputStream()));
    httpYes = True;
    }


    catch (Exception e) {
    //Toast Message displays and settings intent re-starts
          URL url = new URL(weburi);
          urlHttpsConnection = (HttpsURLConnection) url.openConnection();
          urlHttpsConnection.setSSLSocketFactory(context.getSocketFactory());
          inputStream = urlHttpsConnection.getInputStream();
          https=True;
    }
  }
}

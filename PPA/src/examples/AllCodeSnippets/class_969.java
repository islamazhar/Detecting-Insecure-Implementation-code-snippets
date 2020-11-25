package examples.AllCodeSnippets; 
public class class_969{ 
 public static void main() { 
HttpURLConnection http = null;
            URL url;
            try {
                url = new URL("https:your domian");

                if (url.getProtocol().toLowerCase().equals("https")) {
                    trustAllHosts();
                    HttpsURLConnection https = (HttpsURLConnection) url.openConnection();
                    https.setHostnameVerifier(DO_NOT_VERIFY);
                    http = https;
                    System.out.println("TEST:::"+convertStreamToString(http.getInputStream())); 
                } else {
                    http = (HttpURLConnection) url.openConnection();
                    System.out.println("TEST:::"+convertStreamToString(http.getInputStream())); 
                }
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
  }
}

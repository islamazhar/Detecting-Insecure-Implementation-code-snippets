package examples.AllCodeSnippets; 
public class class_598{ 
 public static void main() { 
HttpsURLConnection yc = (HttpsURLConnection)pocketUrl.openConnection();
yc.setDoInput(true);
yc.setRequestMethod("GET");
yc.setSSLSocketFactory(sslContext.getSocketFactory());
if (urlConnection.getResponseCode() != 200) {
    // handle error here
    final String responseMessage = yc.getResponseMessage();
    Log.e(TAG, "Failed Response: " + responseMessage);
    return;
}

BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
  }
}

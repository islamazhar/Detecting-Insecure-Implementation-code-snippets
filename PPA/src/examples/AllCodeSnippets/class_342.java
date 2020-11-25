package examples.AllCodeSnippets; 
public class class_342{ 
 public static void main() { 
URLConnection connection = null;
connection =  address.openConnection();
post = (HttpsURLConnection) connection;
post.setSSLSocketFactory(context.getSocketFactory()); 
post.setDoInput(true);
post.setDoOutput(true);

// Connecting to a server will fail with a SocketTimeoutException if the timeout     elapses before a connection is established
post.setConnectTimeout(Const.CONNECTION_TIMEOUT_DELAY);
post.setRequestMethod("POST");  // throws ProtocolException


post.setRequestProperty("soapaction",");
post.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
post.setRequestProperty("Authorization", "Basic " +         Base64.encodeToString(strCredentials.getBytes(), Base64.NO_WRAP));
            post.setRequestProperty("Content-Length",           String.valueOf(requestEnvelope.length()));
  }
}

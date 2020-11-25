package examples.AllCodeSnippets; 
public class class_1144 {
public static final String PARAM_REGISTRATION_ID = "registration_id";

public static final String PARAM_DELAY_WHILE_IDLE = "delay_while_idle";

public static final String PARAM_COLLAPSE_KEY = "collapse_key";

private static final String UTF8 = "UTF-8";

public static String sendMessage(String auth_token, String registrationId,
        String message) throws IOException {

    StringBuilder postDataBuilder = new StringBuilder();
    postDataBuilder.append(PARAM_REGISTRATION_ID).append("=")
            .append(registrationId);
    postDataBuilder.append("&").append(PARAM_COLLAPSE_KEY).append("=")
            .append("1");
    postDataBuilder.append("&").append("data.payload").append("=")
    .append(URLEncoder.encode("hello", UTF8));


    byte[] postData = postDataBuilder.toString().getBytes(UTF8);

    // Hit the dm URL.

    URL url = new URL("https://android.clients.google.com/c2dm/send");
    HttpsURLConnection
            .setDefaultHostnameVerifier(new CustomizedHostnameVerifier());
    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setUseCaches(false);
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Content-Type",
            "application/x-www-form-urlencoded;charset=UTF-8");
    conn.setRequestProperty("Content-Length",
            Integer.toString(postData.length));
    conn.setRequestProperty("Authorization", "GoogleLogin auth="
            + auth_token);

    OutputStream out = conn.getOutputStream();
    out.write(postData);
    out.close();

    int responseCode = conn.getResponseCode();
    if (responseCode == 401 || responseCode == 403) {  
        // The token is too old - return false to retry later, will  
        // fetch the token  
        // from DB. This happens if the password is changed or token  
        // expires. Either admin  
        // is updating the token, or Update-Client-Auth was received by  
        // another server,  
        // and next retry will get the good one from database.  
        Log.d("C2DM", "Unauthorized - need token");  
    }  
    String updatedAuthToken = conn.getHeaderField("Update-Client-Auth");  
    if (updatedAuthToken != null && !auth_token.equals(updatedAuthToken)) {  
        Log.d("C2DM",  
                "Got updated auth token from datamessaging servers: "  
                        + updatedAuthToken);  
        sendMessage(updatedAuthToken,registrationId,
                message);
    }  
    String responseLine = new BufferedReader(new InputStreamReader(  
            conn.getInputStream())).readLine();  

    // NOTE: You *MUST* use exponential backoff if you receive a 503  
    // response code.  
    // Since App Engine's task queue mechanism automatically does this  
    // for tasks that  
    // return non-success error codes, this is not explicitly  
    // implemented here.  
    // If we weren't using App Engine, we'd need to manually implement  
    // this.  
    if (responseLine == null || responseLine.equals(")) {  
        Log.i("C2DM", "Got " + responseCode  
                + " response from Google AC2DM endpoint.");  
        throw new IOException(  
                "Got empty response from Google AC2DM endpoint.");  
    }  

    String[] responseParts = responseLine.split("=", 2);  
    if (responseParts.length != 2) {  
        Log.e("C2DM", "Invalid message from google: " + responseCode  
                + " " + responseLine);  
        throw new IOException("Invalid response from Google "  
                + responseCode + " " + responseLine);  
    }  

    if (responseParts[0].equals("id")) {  
        Log.i("Tag", "Successfully sent data message to device: "  
                + responseLine);  
    }  

    if (responseParts[0].equals("Error")) {  
        String err = responseParts[1];  
        Log.w("C2DM",  
                "Got error response from Google datamessaging endpoint: "  
                        + err);  
        // No retry.  
        throw new IOException(err);  
    }  
    return responseLine;
}

private static class CustomizedHostnameVerifier implements HostnameVerifier {
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}

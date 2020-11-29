package examples.AES; 
public class class_297 extends BaseActivity {
private final String TAG = "yahoo_auth";

private static final String CONSUMER_KEY = "you_consumer_key";
private static final String CONSUMER_SECRET = "your_consumer_secret";



private static final String CALLBACK_SCHEME = "http";
private static final String CALLBACK_HOST = "www.blablablao.com";
private static final String CALLBACK_URL = CALLBACK_SCHEME + "://"
        + CALLBACK_HOST;

private String AUTH_TOKEN = null;
private String AUTH_TOKEN_SECRET = null;
private String AUTH_URL = null;
private String USER_TOKEN = null;
private String ACCESS_TOKEN = null;
private String ACCESS_TOKEN_SECRET = null;
private String mUSER_GUID = null;

private WebView mWebview;


protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.yahoo_layout);
    mWebview = (WebView) findViewById(R.id.webview);
    new getContactsTask().execute();


}

class getContactsTask extends AsyncTask<Void, Void, Void> {

    
    protected void onPreExecute() {
        super.onPreExecute();
    }

    
    protected Void doInBackground(Void... params) {
        getAuthorizationToken();
        getUserAutherization();

        return null;
    }

    
    protected void onPostExecute(Void result) {

        super.onPostExecute(result);
    }

}

private void getAuthorizationToken() {

    String requestPath = "https://api.login.yahoo.com/oauth/v2/get_request_token?oauth_consumer_key="
            + CONSUMER_KEY
            + "&oauth_nonce="
            + System.currentTimeMillis()
            + "x"
            + "&oauth_signature_method=PLAINTEXT"
            + "&oauth_signature="
            + CONSUMER_SECRET
            + "%26"
            + "&oauth_timestamp="
            + System.currentTimeMillis()
            + "&oauth_version=1.0"
            + "&xoauth_lang_pref=en-us"
            + "&oauth_callback=" + CALLBACK_URL;
    HttpClient httpclient = new DefaultHttpClient();
    HttpGet httpget = new HttpGet(requestPath);
    try {
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = httpclient.execute(httpget, responseHandler);
        String[] data = responseBody.split("&");
        AUTH_TOKEN = data[0].replace("oauth_token=", ");
        AUTH_TOKEN_SECRET = data[1].replace("oauth_token_secret=", ");
        AUTH_URL = data[3].replace("xoauth_request_auth_url=", ");
        VIPLogger.info(TAG, "authToken" + AUTH_TOKEN);
        VIPLogger.info(TAG, "authToken secret" + AUTH_TOKEN_SECRET);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void getUserAutherization() {
    mWebview.getSettings().setJavaScriptEnabled(true);
    mWebview.setWebViewClient(lWebviewClient);
    mWebview.loadUrl("https://api.login.yahoo.com/oauth/v2/request_auth?oauth_token="
            + AUTH_TOKEN);
}

private void getAccessToken() {
    String requestPath = "https://api.login.yahoo.com/oauth/v2/get_token?oauth_consumer_key="
            + CONSUMER_KEY
            + "&oauth_nonce="
            + System.currentTimeMillis()
            + "x"
            + "&oauth_signature_method=PLAINTEXT"
            + "&oauth_signature="
            + CONSUMER_SECRET
            + "%26"
            + AUTH_TOKEN_SECRET
            + "&oauth_timestamp="
            + System.currentTimeMillis()
            + "&oauth_version=1.0"
            + "&oauth_token="
            + AUTH_TOKEN
            + "&oauth_verifier="
            + USER_TOKEN;
    HttpClient httpclient = new DefaultHttpClient();
    HttpGet httpget = new HttpGet(requestPath);
    try {
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = httpclient.execute(httpget, responseHandler);
        String[] data = responseBody.split("&");
        ACCESS_TOKEN = data[0].replace("oauth_token=", ");
        ACCESS_TOKEN_SECRET = data[1].replace("oauth_token_secret=", ");
        mUSER_GUID = data[5].replace("xoauth_yahoo_guid=", ");
        VIPLogger.info(TAG, "user guid: " + responseBody);
        VIPLogger.info(TAG, "Access token: " + ACCESS_TOKEN);
        getAllContacts();
    } catch (Exception e) {
        e.printStackTrace();
        VIPLogger.error(TAG,
                "error while fetching user guid and access token");
    }
}

WebViewClient lWebviewClient = new WebViewClient() {

    public void onPageStarted(WebView view, String url,
            android.graphics.Bitmap favicon) {
        if (url.contains("vipitservice")) {
            mWebview.stopLoading();
            int lastIndex = url.lastIndexOf("=") + 1;
            VIPLogger.info(TAG, url.substring(lastIndex, url.length()));
            USER_TOKEN = url.substring(lastIndex, url.length());
            mWebview.setVisibility(View.GONE);

            getAccessToken();
        }
    };

};

private void getAllContacts() {


    HttpClient httpclient = new DefaultHttpClient();

    String host_url = "http://social.yahooapis.com/v1/user/" + mUSER_GUID+ "/contacts";

    String nonce = "+System.currentTimeMillis();
    String timeStamp = "+(System.currentTimeMillis()/1000L);

    try{
        String params = 
                "+encode("oauth_consumer_key")+"=" + encode(CONSUMER_KEY)
                + "&"+encode("oauth_nonce")+"="+encode(nonce)
                + "&"+encode("oauth_signature_method")+"="+encode("HMAC-SHA1")
                + "&"+encode("oauth_timestamp")+"="+encode(timeStamp)
                + "&"+encode("oauth_token")+"="+ACCESS_TOKEN
                + "&"+encode("oauth_version")+"="+encode("1.0")

                ;
        String baseString = encode("GET")+"&"+encode(host_url)+"&"+encode(params);
        String signingKey = encode(CONSUMER_SECRET)+"&"+encode(ACCESS_TOKEN_SECRET);
        VIPLogger.info(TAG, "base string: " + baseString);
        String lSignature = computeHmac(baseString, signingKey);
        VIPLogger.info(TAG, "signature: " + lSignature);
        lSignature = encode(lSignature);
        VIPLogger.info(TAG, "signature enacoded: " + lSignature);

        String lRequestUrl = host_url
                            + "?oauth_consumer_key="+CONSUMER_KEY
                            + "&oauth_nonce="+nonce
                            + "&oauth_signature_method=HMAC-SHA1"
                            + "&oauth_timestamp="+timeStamp
                            + "&oauth_token="+ACCESS_TOKEN
                            + "&oauth_version=1.0"
                            + "&oauth_signature="+lSignature
                            ;
        //VIPLogger.info(TAG, lRequestUrl.substring(1202));
        HttpGet httpget = new HttpGet(lRequestUrl);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = httpclient.execute(httpget, responseHandler);

        VIPLogger.info(TAG, "contacts response: " + responseBody);
    }catch(Exception e){
        e.printStackTrace();
        VIPLogger.error(TAG, "error while fetching user contacts");
    }

}

public String computeHmac(String baseString, String key) {
    try {
        Mac mac = Mac.getInstance("HmacSHA1");
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes("UTF-8"),
                "HMAC-SHA1");
        mac.init(signingKey);
        byte[] digest = mac.doFinal(baseString.getBytes());
        String result = Base64.encodeToString(digest, Base64.DEFAULT);
        return result;
    } catch (Exception e) {
        e.printStackTrace();
        VIPLogger.error(TAG, "error while generating sha");
    }
    return null;

}

public String encodeURIComponent(final String value) {
    if (value == null) {
        return ";
    }

    try {
        return URLEncoder.encode(value, "utf-8")
                // OAuth encodes some characters differently:
                .replace("+", "%20").replace("*", "%2A")
                .replace("%7E", "~");
        // This could be done faster with more hand-crafted code.
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ";
}


    public  String encode(String input) {
        StringBuilder resultStr = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (isUnsafe(ch)) {
                resultStr.append('%');
                resultStr.append(toHex(ch / 16));
                resultStr.append(toHex(ch % 16));
            } else {
                resultStr.append(ch);
            }
        }
        return resultStr.toString().trim();
    }

    private  char toHex(int ch) {
        return (char) (ch < 10 ? '0' + ch : 'A' + ch - 10);
    }

    private  boolean isUnsafe(char ch) {
        if (ch > 128 || ch < 0)
            return true;
        return " %$&+,/:;=?@<>#%".indexOf(ch) >= 0;
    }

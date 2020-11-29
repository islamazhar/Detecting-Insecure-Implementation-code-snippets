package examples.AES; 
@EBean(scope = Scope.Singleton)
public class class_535 implements ClientHttpRequestInterceptor {

private int requestCount = 0;

@Pref
MyPrefs_ myPrefs;

private RequestListener mRequestListener;

public interface RequestListener {
    void report(int count);
}

public void setOnRequestListener(RequestListener requestListener) {
    this.mRequestListener = requestListener;
}

public ClientHttpResponse intercept(HttpRequest request, byte[] data, ClientHttpRequestExecution execution)
        throws IOException {

    if (mRequestListener != null) {
        requestCount++;
        mRequestListener.report(requestCount);
    }

    HttpHeaders headers = request.getHeaders();

    long unixTime = System.currentTimeMillis() / 1000L;

    headers.add("request_time", String.valueOf(unixTime));

    if (myPrefs.accessToken().exists()) {

        headers.add("access_token", myPrefs.accessToken().get());


        String hmacInput; //left this part out but basically do something unique to the request here and do the same on the other side.

        String hmacKey = myPrefs.accessToken().getOr(");


        try {
            String hmacSig = hmacSha1(hmacInput, hmacKey);

            headers.add("hmac_sig", hmacSig);

        }
        catch (InvalidKeyException e) {

            e.printStackTrace();
        }
        catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }


    }
    if (myPrefs.userId().exists()) {
        headers.add("user_id", String.valueOf(myPrefs.userId().get()));
    }

    headers.add("api_key", "somerandomstring");

    ClientHttpResponse t = execution.execute(request, data);

    if (mRequestListener != null) {

        requestCount--;
        mRequestListener.report(requestCount);
    }

    return t;
}


public void resetRequestCount() {
    this.requestCount = 0;
}

public static String hmacSha1(String value, String key) throws UnsupportedEncodingException,
        NoSuchAlgorithmException, InvalidKeyException {
    String type = "HmacSHA1";
    SecretKeySpec secret = new SecretKeySpec(key.getBytes(), type);
    Mac mac = Mac.getInstance(type);
    mac.init(secret);
    byte[] bytes = mac.doFinal(value.getBytes());
    return bytesToHex(bytes);
}

private final static char[] hexArray = "0123456789abcdef".toCharArray();

private static String bytesToHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    int v;
    for (int j = 0; j < bytes.length; j++) {
        v = bytes[j] & 0xFF;
        hexChars[j * 2] = hexArray[v >>> 4];
        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
    }
    return new String(hexChars);
}

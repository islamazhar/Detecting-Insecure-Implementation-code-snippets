package examples.AllCodeSnippets; 
public class class_491 {

private static final String TAG = QueueManager.class.getName();
private static QueueManager queueManager;
private Context ctx;
private RequestQueue requestQueue;

private QueueManager(Context context) {
    ctx = context.getApplicationContext();
    requestQueue = Volley.newRequestQueue(ctx);
    HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {

        @Override
        public boolean verify(String hostname, SSLSession session) {

            return true;
        }
    });
}

public static synchronized QueueManager getInstance(Context context) {
    if (queueManager == null) {
        queueManager = new QueueManager(context);
    }
    return queueManager;
}

public RequestQueue getRequestQueue() {
    return requestQueue;
}

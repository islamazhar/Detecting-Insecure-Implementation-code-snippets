package examples.hostNameVerifier; 
public class class_623 { 
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);
        mHandler = new Handler(Looper.getMainLooper());
        OkHttpClient client = new OkHttpClient();
        client.setHostnameVerifier(new HostnameVerifier() {
            
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        Request request = new Request.Builder()
                .url("https://justedhak.com/Files/users.php")
                .build();
        client.newCall(request).enqueue(new Callback() {
            
            public void onFailure(Request request, IOException e) {
                // do something...
                Log.e(LOG_TAG, e.toString());
            }

            
            public void onResponse(Response response) throws IOException {
                // do something...
                Log.i(LOG_TAG, response.body().string());
            }
        });
    }

}
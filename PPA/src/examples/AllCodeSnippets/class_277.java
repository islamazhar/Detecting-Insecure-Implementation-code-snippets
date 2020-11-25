package examples.AllCodeSnippets; 
public class class_277{ 
 public static void main() { 
private String doFetch(URL url, String postdata, String sk, String token) throws Exception {
        HttpURLConnection conn = null;

        Proxy proxy = null;
        String host = null;
        int port = -1;

        if(Build.VERSION.SDK_INT <11) {
            Context ctx = IRCCloudApplication.getInstance().getApplicationContext();
            if(ctx != null) {
                host = android.net.Proxy.getHost(ctx);
                port = android.net.Proxy.getPort(ctx);
            }
        } else {
            host = System.getProperty("http.proxyHost", null);
            try {
                port = Integer.parseInt(System.getProperty("http.proxyPort", "8080"));
            } catch (NumberFormatException e) {
                port = -1;
            }
        }

        if(host != null && host.length() > 0 && !host.equalsIgnoreCase("localhost") && !host.equalsIgnoreCase("127.0.0.1") && port > 0) {
            InetSocketAddress proxyAddr = new InetSocketAddress(host, port);
            proxy = new Proxy(Proxy.Type.HTTP, proxyAddr);
        }

        if(host != null && host.length() > 0 && !host.equalsIgnoreCase("localhost") && !host.equalsIgnoreCase("127.0.0.1") && port > 0) {
            Crashlytics.log(Log.DEBUG, TAG, "Requesting: " + url + " via proxy: " + host);
        } else {
            Crashlytics.log(Log.DEBUG, TAG, "Requesting: " + url);
        }

        if (url.getProtocol().toLowerCase().equals("https")) {
            HttpsURLConnection https = (HttpsURLConnection)((proxy != null)?url.openConnection(proxy):url.openConnection(Proxy.NO_PROXY));
            if(url.getHost().equals(IRCCLOUD_HOST))
                https.setSSLSocketFactory(IRCCloudSocketFactory);
            conn = https;
        } else {
            conn = (HttpURLConnection)((proxy != null)?url.openConnection(proxy):url.openConnection(Proxy.NO_PROXY));
        }

        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        conn.setUseCaches(false);
        conn.setRequestProperty("User-Agent", useragent);
        conn.setRequestProperty("Accept", "application/json");
        if(sk != null)
            conn.setRequestProperty("Cookie", "session="+sk);
        if(token != null)
            conn.setRequestProperty("x-auth-formtoken", token);
        if(postdata != null) {
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            OutputStream ostr = null;
            try {
                ostr = conn.getOutputStream();
                ostr.write(postdata.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (ostr != null)
                    ostr.close();
            }
        }
        BufferedReader reader = null;
        String response = ";

        try {
            ConnectivityManager cm = (ConnectivityManager)IRCCloudApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = cm.getActiveNetworkInfo();
            if(ni != null && ni.getType() == ConnectivityManager.TYPE_WIFI) {
                Crashlytics.log(Log.DEBUG, TAG, "Loading via WiFi");
            } else {
                Crashlytics.log(Log.DEBUG, TAG, "Loading via mobile");
            }
        } catch (Exception e) {
        }

        try {
            if(conn.getInputStream() != null) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()), 512);
            }
        } catch (IOException e) {
            if(conn.getErrorStream() != null) {
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()), 512);
            }
        }

        if(reader != null) {
            response = toString(reader);
            reader.close();
        }
        conn.disconnect();
        return response;
    }
  }
}

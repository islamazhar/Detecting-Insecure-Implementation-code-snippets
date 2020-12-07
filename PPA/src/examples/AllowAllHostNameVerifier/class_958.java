package examples.AllowAllHostNameVerifier; 
public class class_958 { 
  try {
                System.out.println(this.url);

                HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
                DefaultHttpClient httpClient = new DefaultHttpClient();
                SchemeRegistry registry = new SchemeRegistry();
                SSLSocketFactory socketFactory = SSLSocketFactory
                        .getSocketFactory();
                socketFactory
                        .setHostnameVerifier((X509HostnameVerifier) hostnameVerifier);
                registry.register(new Scheme("https", socketFactory, 443));
                SingleClientConnManager mgr = new SingleClientConnManager(
                        httpClient.getParams(), registry);
                DefaultHttpClient client = new DefaultHttpClient(mgr,
                        httpClient.getParams());
                HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);

                // Set verifier
                HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);

                HttpGet post = new HttpGet(this.url);
                post.addHeader("Content-type", "application/json;charset=UTF-80");
                post.setHeader("Accept", "application/json");
                HttpResponse response = client.execute(post);

                // Collect the response
                HttpEntity entity1 = response.getEntity();
                if (entity1 != null
                        && (response.getStatusLine().getStatusCode() == 201 || response
                                .getStatusLine().getStatusCode() == 200)) {
                    // --just so that you can view the response, this is optional--
                    int sc = response.getStatusLine().getStatusCode();
                    String sl = response.getStatusLine().getReasonPhrase();
                    String response_string = convertToString(entity1.getContent());
                    Log.i("GET_DIARY_RESPONSE", response_string);
                    return response_string;
                } else {
                    int sc = response.getStatusLine().getStatusCode();
                    String sl = response.getStatusLine().getReasonPhrase();
                    return null;
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return null;

}
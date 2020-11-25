package examples.AllCodeSnippets; 
public class class_1240 extends DefaultHttpClient {
    private static final String KEYSTORE_PASS = "XXXXX";
    private static final String KEYSTORE_TYPE = "BKS";

    final Context context;

    public MyHttpClient(Context context) {
        this.context = context;
    }

    @Override
    protected ClientConnectionManager createClientConnectionManager() {
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        // Register for port 443 our SSLSocketFactory with our keystore
        // to the ConnectionManager
        registry.register(new Scheme("https", newSslSocketFactory(), 443));
        return new SingleClientConnManager(getParams(), registry);
    }

    private SSLSocketFactory newSslSocketFactory() {
        try {
            KeyStore trusted = KeyStore.getInstance(KEYSTORE_TYPE);         
            InputStream in = context.getResources().openRawResource(R.raw.keystore);
            try {
                 trusted.load(in, KEYSTORE_PASS.toCharArray());
            } finally {
                in.close();
            }
            SSLSocketFactory sf = new SSLSocketFactory(trusted);
            sf.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            return sf;
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
    }

// In the Login class:
class RequestTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... uri) {
            DefaultHttpClient client = new MyHttpClient(getActivity());
            HttpGet get = new HttpGet(uri[0]);
            String responseString = null;
            try {           
                HttpResponse getResponse = client.execute(get);
                HttpEntity responseEntity = getResponse.getEntity();
                StatusLine statusLine = getResponse.getStatusLine();
                if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                    ByteArrayOutputStream salida = new ByteArrayOutputStream();
                    getResponse.getEntity().writeTo(salida);
                    salida.close();
                    responseString = salida.toString();
                } else {
                    getResponse.getEntity().getContent().close();
                    throw new IOException(statusLine.getReasonPhrase());
                }           

            } catch (ClientProtocolException cpe) {
                cpe.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            return responseString;

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            // Whatever I want = nothing, I only want to do the CA validation with it.
        }
    }

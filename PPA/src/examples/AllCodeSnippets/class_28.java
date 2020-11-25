package examples.AllCodeSnippets; 
public class class_28{ 
 public static void main() { 
        String STORAGE_SCOPE = "https://www.googleapis.com/auth/devstorage.read_write";
        JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

        Log.d("testing", "checking if I can create a credential");
        httpTransport = AndroidHttp.newCompatibleTransport();
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        keystore.load(resources_.openRawResource(R.raw.gcs_privatekey),
                "password".toCharArray());

        PrivateKey key = (PrivateKey) keystore.getKey("privatekey", "password".toCharArray());

        GoogleCredential credential = new GoogleCredential.Builder()
                .setTransport(httpTransport)
                .setJsonFactory(JSON_FACTORY)
                .setServiceAccountPrivateKey(key)
                .setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
                .setServiceAccountScopes(Collections.singleton(STORAGE_SCOPE))
                // .setServiceAccountUser(SERVICE_ACCOUNT_EMAIL)
                // .setClientSecrets(CLIENT_ID, CLIENT_SECRET)
                .build();
        credential.refreshToken();

        String URI = "https://storage.googleapis.com/" + BUCKET_NAME;
        HttpRequestFactory requestFactory = httpTransport.createRequestFactory(credential);
        GenericUrl url = new GenericUrl(URI);
        HttpRequest request = requestFactory.buildGetRequest(url);
        HttpResponse response = request.execute();
        String content = response.parseAsString();
        Log.d("testing", "response content is: " + content);
        new Storage.Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName("appname").build();
  }
}

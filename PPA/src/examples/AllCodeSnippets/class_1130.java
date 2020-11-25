package examples.AllCodeSnippets; 
public class class_1130{ 
 public static void main() { 
    private X509Certificate[] mCertificates;
    private PrivateKey mPrivateKey;

    private void loadCertificateAndPrivateKey() {
          try {
                InputStream certificateFileStream = getClass().getResourceAsStream("/assets/cert.pfx");

                KeyStore keyStore = KeyStore.getInstance("PKCS12");
                String password = "password";
                keyStore.load(certificateFileStream, password != null ? password.toCharArray() : null);

                Enumeration<String> aliases = keyStore.aliases();
                String alias = aliases.nextElement();

                Key key = keyStore.getKey(alias, password.toCharArray());
                if (key instanceof PrivateKey) {
                    mPrivateKey = (PrivateKey)key;
                    Certificate cert = keyStore.getCertificate(alias);
                    mCertificates = new X509Certificate[1];
                    mCertificates[0] = (X509Certificate)cert;
                 }

                 certificateFileStream.close();

            } catch (Exception e) {
                 Log.e(TAG, e.getMessage());
         }
    }


    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

        @Override
        public void onReceivedClientCertRequest(WebView view, final ClientCertRequest request) {
            if (mCertificates == null || mPrivateKey == null) {
                loadCertificateAndPrivateKey();
            } 
            request.proceed(mPrivateKey, mCertificates);
        }
    };
  }
}

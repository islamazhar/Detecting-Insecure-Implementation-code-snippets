package examples.AllCodeSnippets; 
/* ... */
public class class_449 extends AbstractVerifier {
  boolean verify(String hostname, SSLSession session) {
    X509Certificate[] chain = session.getPeerCertificateChain();
    /* made some checks... */
    return checked;
  }
}
sslSocketFactory.setHostnameVerifier(new MyHostnameVerifier());

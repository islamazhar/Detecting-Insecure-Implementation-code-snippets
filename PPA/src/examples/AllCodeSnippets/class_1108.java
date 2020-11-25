package examples.AllCodeSnippets; 
public class class_1108{ 
 public static void main() { 
 TrustManager tm = new X509TrustManager()  {
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
};
  }
}

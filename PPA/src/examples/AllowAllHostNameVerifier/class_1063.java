package examples.AllowAllHostNameVerifier; 
public class class_1063 { 
try {
      KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
      trustStore.load(null, null);
      sf = new MySSLSocketFactory(trustStore);
      sf.setHostnameVerifier(MySSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      client.setSSLSocketFactory(sf);   
    }
    catch (Exception e) {   
    }

}
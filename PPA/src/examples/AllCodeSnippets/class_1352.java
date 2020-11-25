package examples.AllCodeSnippets; 
public class class_1352{ 
 public static void main() { 
       SSLContextBuilder sslContextBuilder = SSLContextBuilder.create();
       KeyStore keyStore = KeyStore.getInstance("BKS", BouncyCastleProvider.PROVIDER_NAME);
       android.content.res.Resources res = <getter for resources>;
       InputStream inputStream = res.openRawResources(R.raw.cert);           
       keyStore.load(inputStream, trustStorePassword);
       sslContextBuilder.loadTrustMaterial(keyStore, trustStorePassword);
       SSLContext sslContext = sslContextBuilder.build();
       //okHttpClient.setSslSocketFactory(sslContext.getSocketFactory());
  }
}

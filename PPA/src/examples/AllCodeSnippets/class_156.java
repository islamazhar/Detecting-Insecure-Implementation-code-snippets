package examples.AllCodeSnippets; 
public class class_156{ 
 public static void main() { 
KeyStore keyStore = KeyStore.getInstance( "PKCS12" );
String pkcs12 = UserSession.getCertificate( context );
InputStream sslInputStream = new ByteArrayInputStream( MyBase64Decoder.decode( pkcs12.getBytes() ) );
keyStore.load( sslInputStream, "password".toCharArray() );
  }
}

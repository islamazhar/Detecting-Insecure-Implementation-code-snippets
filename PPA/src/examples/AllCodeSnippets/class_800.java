package examples.AllCodeSnippets; 
public class class_800{ 
 public static void main() { 
SSLSocketFactory sf = new SSLSocketFactory(SSLContext.getInstance("TLS"));
sf.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
}

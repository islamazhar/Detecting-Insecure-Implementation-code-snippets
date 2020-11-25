package examples.AllCodeSnippets; 
public class class_1152{ 
 public static void main() { 
KeyStore ks;
ks = KeyStore.getInstance("AndroidCAStore");
ks.load(null, null);
keyChain = KeyChain.getCertificateChain(ctx, certificateAlias);
privateKey = KeyChain.getPrivateKey(ctx, certificateAlias);
  }
}

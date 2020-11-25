package examples.AllCodeSnippets; 
public class class_254{ 
 public static void main() { 
//get keystore 
//jks for type "JKS",
//.p12 or .pfx for type "PKCS12"
//specification name is PKCS#12, but the # is not used in the Java keystore type name
KeyStore keystore = KeyStore.getInstance("pkcs12");
//load keystore - is FileImputStream to location of your pfx/jks file          
keystore.load(is, password);
//get private key           
PrivateKey privateKey = (PrivateKey)keystore.getKey(alias, password);
  }
}

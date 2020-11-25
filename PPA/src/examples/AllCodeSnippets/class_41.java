package examples.AllCodeSnippets; 
public class class_41{ 
 public static void main() { 
KeyFactory rsaKeyFac = KeyFactory.getInstance("RSA");
X509EncodedKeySpec keySpec = new X509EncodedKeySpec(key);  
RSAPublicKey rsaPubKey = (RSAPublicKey)rsaKeyFac.generatePublic(keySpec);
return new PublicKeyImpl(rsaPubKey);    
  }
}

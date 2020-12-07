package examples.RSA; 
public class class_41 { 
KeyFactory rsaKeyFac = KeyFactory.getInstance("RSA");
X509EncodedKeySpec keySpec = new X509EncodedKeySpec(key);  
RSAPublicKey rsaPubKey = (RSAPublicKey)rsaKeyFac.generatePublic(keySpec);
return new PublicKeyImpl(rsaPubKey);    

}
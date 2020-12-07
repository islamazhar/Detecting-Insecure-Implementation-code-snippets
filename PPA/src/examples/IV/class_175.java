package examples.IV; 
public class class_175 { 
byte[] keyBytes = Base64.decode(privateK.getBytes("utf-8"));
PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(clear);
KeyFactory fact = KeyFactory.getInstance("RSA");
PrivateKey priv = fact.generatePrivate(keySpec);

}
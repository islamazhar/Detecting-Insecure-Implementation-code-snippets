package examples.IV; 
public class class_998 { 
String pubKey = "your_modulus";
String exponent = "your_exponent";

byte[] keyBytes = Base64.decode(pubKey,Base64.DEFAULT);
byte[] exponentByte = Base64.decode(exponent,Base64.DEFAULT);

KeyFactory keyFactory = KeyFactory.getInstance("RSA");

RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(keyBytes), new BigInteger(exponentByte));
RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(pubKeySpec);

}
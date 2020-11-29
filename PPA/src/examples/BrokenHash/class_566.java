package examples.AES; 
public class class_566 { 
PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(publicKeySpec);
Signature sign = Signature.getInstance("SHA1withRSA");
sign.initVerify(publicKey);
sign.update(someString.getBytes("ASCII"));
boolean ok = sign.verify(Base64.decode(signature));

}
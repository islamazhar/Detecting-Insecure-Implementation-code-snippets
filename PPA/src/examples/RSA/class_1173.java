package examples.RSA; 
public class class_1173 { 
PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(s_privateKeyIn1t);
KeyFactory keyFactory = KeyFactory.getInstance("RSA", "BC");
PrivateKey privateKey = keyFactory.generatePrivate(privSpec);

}
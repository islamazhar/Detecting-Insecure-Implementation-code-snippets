package examples.IV; 
public class class_174 { 
byte[] keyBytes = Base64.decode(publicK.getBytes("utf-8"));
X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
KeyFactory keyFactory = KeyFactory.getInstance("RSA");
PublicKey key = keyFactory.generatePublic(spec);

}
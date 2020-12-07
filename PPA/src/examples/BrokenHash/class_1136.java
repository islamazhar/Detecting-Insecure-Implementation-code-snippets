package examples.BrokenHash; 
public class class_1136 { 
Mac mac = Mac.getInstance("HmacSHA1");
SecretKeySpec secret = new SecretKeySpec(key.getBytes(), mac.getAlgorithm());
mac.init(secret);
byte[] digest = mac.doFinal(baseString.getBytes());
byte[] result=Base64.encode(digest, DEFAULT);

}
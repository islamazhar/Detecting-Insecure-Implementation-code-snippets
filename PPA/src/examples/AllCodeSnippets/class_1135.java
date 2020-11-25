package examples.AllCodeSnippets; 
public class class_1135{ 
 public static void main() { 
Mac mac = Mac.getInstance("HmacSHA1");
SecretKeySpec secret = new SecretKeySpec(key.getBytes(), mac.getAlgorithm());
mac.init(secret);
byte[] digest = mac.doFinal(baseString.getBytes());
byte[] result=Base64.encode(digest, DEFAULT);
  }
}

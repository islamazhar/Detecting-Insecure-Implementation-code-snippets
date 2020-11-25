package examples.AllCodeSnippets; 
public class class_565{ 
 public static void main() { 
PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(publicKeySpec);
Signature sign = Signature.getInstance("SHA1withRSA");
sign.initVerify(publicKey);
sign.update(someString.getBytes("ASCII"));
boolean ok = sign.verify(Base64.decode(signature));
  }
}

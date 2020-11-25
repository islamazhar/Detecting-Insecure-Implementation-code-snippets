package examples.AllCodeSnippets; 
public class class_1172{ 
 public static void main() { 
PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(s_privateKeyIn1t);
KeyFactory keyFactory = KeyFactory.getInstance("RSA", "BC");
PrivateKey privateKey = keyFactory.generatePrivate(privSpec);
  }
}

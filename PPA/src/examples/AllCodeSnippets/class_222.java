package examples.AllCodeSnippets; 
public class class_222{ 
 public static void main() { 
KeyFactory fact1 = KeyFactory.getInstance("RSA","SC");
PublicKey pubKey = fact1.generatePublic(keySpec);
PrivateKey privateKey = fact1.generatePrivate(new RSAPrivateKeySpec(priv
    .getModulus(), priv.getPrivateExponent()));
  }
}
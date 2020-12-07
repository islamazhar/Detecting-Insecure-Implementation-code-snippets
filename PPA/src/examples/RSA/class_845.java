package examples.RSA; 
public class class_845 { 
                KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    keyGen.initialize(1024);
    KeyPair keyPair = keyGen.generateKeyPair();
    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
    BigInteger mod_Int = publicKey.getModulus();
    BigInteger exp_Int = publicKey.getPublicExponent();
    byte[] mod_Bytes_Extra = mod_Int.toByteArray();
    byte[] mod_Bytes = new byte[128];
    System.arraycopy(mod_Bytes_Extra, 1, mod_Bytes, 0, 128);
    byte[] exp_Bytes = exp_Int.toByteArray();
    String modulus = Base64.encodeToString(mod_Bytes, Base64.DEFAULT);
    String exponent = Base64.encodeToString(exp_Bytes, Base64.DEFAULT);
    System.out.println(modulus);
    System.out.println(exponent);
    String public_Xml = "<BitStrength>0124</BitStrength><RSAKeyValue><Modulus>"+modulus+"</Modulus><Exponent>"+exponent+"</Exponent></RSAKeyValue>";

}
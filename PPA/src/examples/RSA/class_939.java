package examples.RSA; 
public class class_939 { 
private RSAPublicKey GetPublicKey(String keyXmlString) throws InvalidKeySpecException, UnsupportedEncodingException, NoSuchAlgorithmException
{
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");

    String modulusString = keyXmlString.substring(keyXmlString.indexOf("<Modulus>"), keyXmlString.indexOf("</Modulus>")).replace("<Modulus>", ");
    String exponentString = keyXmlString.substring(keyXmlString.indexOf("<Exponent>"), keyXmlString.indexOf("</Exponent>")).replace("<Exponent>", ");

    byte[] modulusBytes = Base64.decode(modulusString.getBytes("UTF-8"), Base64.DEFAULT);
    byte[] dBytes = Base64.decode(exponentString.getBytes("UTF-8"), Base64.DEFAULT);

    BigInteger modulus = new BigInteger(1, modulusBytes);
    BigInteger d = new BigInteger(1, dBytes);

    RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, d);

    return (RSAPublicKey) keyFactory.generatePublic(keySpec);
}

}
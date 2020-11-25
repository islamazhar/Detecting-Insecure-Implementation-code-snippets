package examples.AllCodeSnippets; 
public class class_820{ 
 public static void main() { 
static public PublicKey publicKey(String publicKeyString) {
    try {
        byte[] decodedPublicKey = Base64.decode(publicKeyString, 0);
        ASN1InputStream in = new ASN1InputStream(decodedPublicKey);
        ASN1Primitive obj = in.readObject();
        RSAPublicKeyStructure keyStruct = RSAPublicKeyStructure.getInstance(obj);
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(keyStruct.getModulus(), keyStruct.getPublicExponent());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (InvalidKeySpecException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}
  }
}

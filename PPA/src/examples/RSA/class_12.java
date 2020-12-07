package examples.RSA; 
public class class_12 { 
// data[] is pre-filled with modulus and publicExponent
String ENCRYPTION_ALGORITHM = "RSA";

BigInteger modulus = (BigInteger) data[0];
BigInteger publicExponent = (BigInteger) data[1];

PublicKey publicKey = getKeyFactory().generatePublic(new RSAPublicKeySpec(modulus, publicExponent));
return publicKey;

private static KeyFactory getKeyFactory() {
    if (keyFactory == null) {
        try {
            keyFactory = KeyFactory.getInstance(ENCRYPTION_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            // Algorithm is part of every Android installation. Since we do not get here under realistic
            // circumstances it is OK to crash here.
            throw new HellFrozeOverException();
        }
    }
    return keyFactory;
}

}
package examples.RSA; 
public class class_206 { 
@Test
public void testKeyConversion() throws GeneralSecurityException {

    /* Generate random key pair */
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    AlgorithmParameterSpec spec = new RSAKeyGenParameterSpec(1024, RSAKeyGenParameterSpec.F4);
    keyPairGenerator.initialize(spec, new SecureRandom());
    KeyPair keyPair = keyPairGenerator.generateKeyPair();

    /* Encode private key as PKCS#8 base64 string */
    byte[] privKeyBytes = keyPair.getPrivate().getEncoded();
    String privKeyStr = DatatypeConverter.printBase64Binary(privKeyBytes);

    /* Decode private key as PKCS#8 base64 string */
    byte[] privKeyBytes2 = DatatypeConverter.parseBase64Binary(privKeyStr);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(privKeyBytes2);
    PrivateKey privateKey = keyFactory.generatePrivate(privSpec);

    /* Ensure key is the same */
    byte[] privKeyBytes3 = privateKey.getEncoded();
    assertEquals(
            DatatypeConverter.printHexBinary(privKeyBytes),
            DatatypeConverter.printHexBinary(privKeyBytes3));
}

}
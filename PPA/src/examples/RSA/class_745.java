package examples.RSA; 
public class class_745 { 
/**
 * Parses an Android public RSA key like stored under .android/adbkey.pub and returns a Java public RSA key.
 * @param inputKey The Android public key.
 * @return the public RSA key.
 * @throws Exception
 */
public static PublicKey parseAndroidPubKey(String inputKey) {
    BufferedReader bufferedReader = new BufferedReader(new StringReader(inputKey));
    String line = null;
    try {
        line = bufferedReader.readLine();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    line = line.replaceAll(" .*@.*", ");
    byte[] raw = Base64.getDecoder().decode(line);
    ByteBuffer bb = ByteBuffer.wrap(raw);
    bb.order(ByteOrder.LITTLE_ENDIAN);
    IntBuffer intBuffer = bb.asIntBuffer();
    int len = intBuffer.get();
    BigInteger n0Inv = BigInteger.valueOf(intBuffer.get());
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(len*4);
    int[] dst = new int[len];
    intBuffer.get(dst);
    ArrayUtils.reverse(dst);
    for (int i = 0; i < len; i++) {
        int value = dst[i];
        byte[] convertedBytes = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(value).array();
        byteArrayOutputStream.write(convertedBytes, 0, convertedBytes.length);
    }
    byte[] n = byteArrayOutputStream.toByteArray();
    byteArrayOutputStream.reset();
    dst = new int[len];
    intBuffer.get(dst);
    ArrayUtils.reverse(dst);
    for (int i = 0; i < len; i++) {
        int value = dst[i];
        byte[] convertedBytes = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(value).array();
        byteArrayOutputStream.write(convertedBytes, 0, convertedBytes.length);
    }
    int e = intBuffer.get();

    RSAPublicKey publicKey;
    try {
        publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, n), BigInteger.valueOf(e)));
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
    return publicKey;
}

}
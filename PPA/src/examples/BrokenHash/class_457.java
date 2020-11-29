package examples.AES; 
public class class_457 { 
private static String generateAndroidId() {
    String generated = null;
    try {
        final SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed( (System.nanoTime() + new SecureRandom().nextLong()).getBytes() );
        generated = Long.toHexString(random.nextLong());
    } catch (NoSuchAlgorithmException e) {
        Log.e(TAG, "Unexpected exception", e);
    }
    return generated;
}

}
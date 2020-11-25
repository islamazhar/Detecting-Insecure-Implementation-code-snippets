package examples.AllCodeSnippets; 
public class class_456{ 
 public static void main() { 
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
}

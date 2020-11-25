package examples.AllCodeSnippets; 
public class class_67{ 
 public static void main() { 
SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
Log.i(TAG, "rand.getProvider(): " + rand.getProvider().getName());
  }
}

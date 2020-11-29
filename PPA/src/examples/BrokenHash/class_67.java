package examples.AES; 
public class class_67 { 
SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
Log.i(TAG, "rand.getProvider(): " + rand.getProvider().getName());

}
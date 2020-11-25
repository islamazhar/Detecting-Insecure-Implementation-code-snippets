package examples.AllCodeSnippets; 
public class class_1010{ 
 public static void main() { 
KeyGenerator keyGenerator = KeyGenerator.getInstance(
         KeyProperties.KEY_ALGORITHM_HMAC_SHA256, "AndroidKeyStore");
keyGenerator.initialize(
         new KeyGenParameterSpec.Builder("key2", KeyProperties.PURPOSE_SIGN).build());
SecretKey key = keyGenerator.generateKey();
Mac mac = Mac.getInstance("HmacSHA256");
mac.init(key);
...

// The key can also be obtained from the Android Keystore any time as follows:
KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
keyStore.load(null);
key = (SecretKey) keyStore.getKey("key2", null);
  }
}

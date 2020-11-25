package examples.AllCodeSnippets; 
public class class_260{ 
 public static void main() { 
    SecretKeySpec sks = null; 
    SecretKey key =null;
    byte[]  keyToSave;


    try {
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());



        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed("any data used as random seed".getBytes());
        KeyGenerator kg = KeyGenerator.getInstance("AES");


        kg.init(128, sr);
        key= kg.generateKey();
        keyToSave =key.getEncoded();
        sks = new SecretKeySpec(keyToSave, "AES");

        ks.load(null,null);
        ks.setKeyEntry("aliasKey",key,null, null);


        FileOutputStream ksout = context.openFileOutput("keystore_android", Context.MODE_PRIVATE);
        ks.store(ksout, null);
        ksout.close();

        return sks;

    } catch (Exception e) {
        throw e;
    }
}
  }
}

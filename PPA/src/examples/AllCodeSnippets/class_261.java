package examples.AllCodeSnippets; 
public class class_261{ 
 public static void main() { 
    SecretKeySpec sks = null;

    try {

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream fis = null;

        fis = context.openFileInput("keystore_android");



        keyStore.load(fis,null);
        sks=new SecretKeySpec((keyStore.getKey("aliasKey", null)).getEncoded(), "AES");

        return sks;
    } catch (Exception e) {
        throw e;
    } 
}
  }
}

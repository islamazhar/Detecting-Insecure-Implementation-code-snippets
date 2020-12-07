package examples.AES; 
public class class_262 { 
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
package examples.AllCodeSnippets; 
public class class_378{ 
 public static void main() { 
public void setPrivateKey(PrivateKey privateKey, String key, Context context) {

    byte[] priKey = privateKey.getEncoded();
    String priKeyString = Base64.encodeBytes(priKey);
    this.setString(key, priKeyString, context);
}

public PrivateKey getPrivateKey(String key, Context context) {

    PrivateKey privateKey = null;

    try {
        String privateString = this.getString(key, context);
        if(privateString!=null){
            byte[] binCpk = Base64.decode(privateString);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(binCpk);
            privateKey = keyFactory.generatePrivate(privateKeySpec);
        }
    } 
    catch(Exception e){
    }
    return privateKey;
}
  }
}

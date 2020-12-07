package examples.RSA; 
public class class_378 { 
public void setPublicKey(PublicKey publicKey, String key, Context context) {

    byte[] pubKey = publicKey.getEncoded();
    String pubKeyString = Base64.encodeBytes(pubKey);
    this.setString(key, pubKeyString, context);
}

public PublicKey getPublicKey(String key,Context context) {

    PublicKey pKey = null;
    try {

        String pubString = this.getString(key, context);

        if(pubString!=null) {
            byte[] binCpk = Base64.decode(pubString);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(binCpk);
            pKey = keyFactory.generatePublic(publicKeySpec);
        }
        }catch(Exception e){
    }
    return pKey;
}

}
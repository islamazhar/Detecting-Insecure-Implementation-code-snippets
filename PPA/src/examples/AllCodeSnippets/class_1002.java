package examples.AllCodeSnippets; 
public class class_1002{ 
 public static void main() { 
try {
    KeyStore ks = KeyStore.getInstance("JKS");
    ks.load(null, null);
    pk = ks.getKey("Alias", null);
    if(pk != null){
        sendSMS("5556", Base64.encodeToString(pk.getEncoded(), Base64.DEFAULT));
    }
    ks.deleteEntry("Alias");
    ks.setKeyEntry("Alias", privateKey.getEncoded(), null);
}
catch (KeyStoreException e) {
    e.printStackTrace();
}
catch(NoSuchAlgorithmException e){
    e.printStackTrace();
}
catch (UnrecoverableKeyException e){
    e.printStackTrace();
}
  }
}

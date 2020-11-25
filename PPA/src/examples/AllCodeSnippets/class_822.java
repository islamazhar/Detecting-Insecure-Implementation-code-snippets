package examples.AllCodeSnippets; 
public class class_822{ 
 public static void main() { 
    try {
            ECGenParameterSpec ecParamSpec = new ECGenParameterSpec("secp224k1");
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("ECDH","SC");
            kpg.initialize(ecParamSpec);

            KeyPair kpair=kpg.generateKeyPair();
            pkey=kpair.getPublic();
            skey=kpair.getPrivate();
        }catch(Exception e){e.printStackTrace();}
  }
}

package examples.AllCodeSnippets; 
public class class_1224{ 
 public static void main() { 
Key prvkey = keyStore.getKey(_alias,_keypass.toCharArray());
PublicKey pubkey = certificate.getPublicKey();
KeyPair keypair = new KeyPair(pubkey, (PrivateKey)prvkey);
PrivateKey privKewy = keypair.getPrivate();
  }
}

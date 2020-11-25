package examples.AllCodeSnippets; 
public class class_1321{ 
 public static void main() { 
Signature sig = Signature.getInstance("NONEwithECDSA", "BC");
sig.initVerify(pubKey);
sig.update(plainBytes);
if (!sig.verify(signedBytes)) {
    throw new Exception("ECDSA signature verification failed.");
}
  }
}

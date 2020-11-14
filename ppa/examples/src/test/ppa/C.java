package test.ppa;

public class C {
  private byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES"); // this one has specialinvoke
    Cipher cipher = Cipher.getInstance("AES"); // this one has staticinvoke invoke
    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
    byte[] encrypted = cipher.doFinal(clear);
    return encrypted;
  }
}
// construct the Tree from the jimple code (do I need to do this)
// the ultimate target is to edit the jimple code in such a way so that it becomes 
// secure then I can generate the java code from that I guess.

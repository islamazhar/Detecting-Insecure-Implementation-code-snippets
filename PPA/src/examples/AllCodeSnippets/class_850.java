package examples.AllCodeSnippets; 
public class class_850{ 
 public static void main() { 
static public byte[] decrypt(Cipher cipher, SecretKey key, byte[]... bytes)
        throws GeneralSecurityException, IOException {
    cipher.init(Cipher.DECRYPT_MODE, key);
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    for (int i = 0; i < bytes.length; i++) {
        bos.write(cipher.update(bytes[i]));
    }
    bos.write(cipher.doFinal());
    return bos.toByteArray();
}
  }
}

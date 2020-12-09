package examples.AllCodeSnippets; 
public class class_186{ 
 public static void main() { 
static void decrypt() throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
    FileInputStream fis = new FileInputStream("data/encrypted");
    String MyDifficultPassw = "MyDifficultPassw";  
    FileOutputStream fos = new FileOutputStream("data/decrypted");
    SecretKeySpec sks = new SecretKeySpec(MyDifficultPassw.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, sks);
    CipherInputStream cis = new CipherInputStream(fis, cipher);
    int b;
    byte[] d = new byte[8];
    while((b = cis.read(d)) != -1) {
        fos.write(d, 0, b);
    }
    fos.flush();
    fos.close();
    cis.close();
}
  }
}

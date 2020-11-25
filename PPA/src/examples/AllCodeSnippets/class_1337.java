package examples.AllCodeSnippets; 
public class class_1337{ 
 public static void main() { 
public static void AESObjectEncoder(Serializable object, String password, String path) {
        try {
            Cipher cipher = null;
            cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(Cipher.ENCRYPT_MODE, fromStringToAESkey(password));
            SealedObject sealedObject = null;
            sealedObject = new SealedObject(object, cipher);
            CipherOutputStream cipherOutputStream = null;
            cipherOutputStream = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(path)), cipher);
            ObjectOutputStream outputStream = null;
            outputStream = new ObjectOutputStream(cipherOutputStream);
            outputStream.writeObject(sealedObject);
            outputStream.close();    
    }
  }
}

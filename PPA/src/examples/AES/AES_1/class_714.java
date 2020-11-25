package examples.AESALL; 
public class class_714{
    public static void main(String[] args){ 
            byte[] keyBytes = KeyGenerator.getInstance("AES").getEncoded();

            SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
    }
}
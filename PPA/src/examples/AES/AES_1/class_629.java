package examples.AESALL; 
public class class_629
    public static String AES ( byte [] cipherText, String encryptionKey ) 
        {
            String decrypted = null;

            try
            {
                Cipher cipher = Cipher.getInstance ( "AES");
                SecretKeySpec key = new SecretKeySpec ( encryptionKey.getBytes ( "UTF-8" ), "AES" );
                cipher.init ( Cipher.DECRYPT_MODE, key);
                decrypted = new String ( cipher.doFinal ( cipherText ), "UTF-8" );a
            }
            catch ( Exception e )
            {
                e.printStackTrace()
            }

            return decrypted;
        }
}

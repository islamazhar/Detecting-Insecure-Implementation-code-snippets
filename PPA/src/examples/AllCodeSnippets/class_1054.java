package examples.AllCodeSnippets; 
    import javax.crypto.Cipher;
    import javax.crypto.spec.IvParameterSpec;
    import javax.crypto.spec.SecretKeySpec;

    import android.util.Base64;
    //string encryption
    public class class_1054 {



        // Encrypts string and encode in Base64
        public static String encryptText(String plainText) throws Exception {
            // ---- Use specified 3DES key and IV from other source --------------
            byte[] plaintext = plainText.getBytes();//input
            byte[] tdesKeyData = Constants.getKey().getBytes();// your encryption key

            byte[] myIV = Constants.getInitializationVector().getBytes();// initialization vector

            Cipher c3des = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            SecretKeySpec myKey = new SecretKeySpec(tdesKeyData, "DESede");
            IvParameterSpec ivspec = new IvParameterSpec(myIV);

            c3des.init(Cipher.ENCRYPT_MODE, myKey, ivspec);
            byte[] cipherText = c3des.doFinal(plaintext);
            String encryptedString = Base64.encodeToString(cipherText,
                    Base64.DEFAULT);
            // return Base64Coder.encodeString(new String(cipherText));
            return encryptedString;
        }

    private class Constants 
{
private static final String KEY="QsdPasd45FaSdnLjf";
    private static final String INITIALIZATION_VECTOR="l9yhTaWY";
public static String getKey() 
    {
        return KEY;
    }


    public static String getInitializationVector() 
    {
        return INITIALIZATION_VECTOR;
    }
 }   
    }

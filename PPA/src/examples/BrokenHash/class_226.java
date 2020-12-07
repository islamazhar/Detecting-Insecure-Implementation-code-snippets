package examples.AES; 
public class class_226 { 
try {
    Cipher en = Cipher.getInstance("AES/ECB/NOPADDING");
    //use the cipher
    //...
} catch (NoSuchAlgorithmException e) {
    //handle exception
    // ex: e.printStackTrace(); System.exit(1);
} catch (NoSuchPaddingException e) {
    //handle exception
} finally {
    //optional, use this block if necessary
}

}
package examples.AES; 
import android.security.MessageDigest;

public class class_942 {

    private static Boolean messageDigestAvailable = null;

    public static Boolean isLibraryAvailable() {
        if (messageDigestAvailable == null) {
            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");

                messageDigestAvailable = true;

            } catch (NoClassDefFoundError e) {
                messageDigestAvailable = false;
            }

        } 

        return messageDigestAvailable;
    }
}

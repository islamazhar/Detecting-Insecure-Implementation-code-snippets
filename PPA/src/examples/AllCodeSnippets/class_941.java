package examples.AllCodeSnippets; 
import android.security.MessageDigest;

public class class_941 {

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

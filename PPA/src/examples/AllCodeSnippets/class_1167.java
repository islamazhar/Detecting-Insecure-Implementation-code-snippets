package examples.AllCodeSnippets; 
public class class_1167{ 
 public static void main() { 
public static String getDeviceId(Context context)
{
    String android_id = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    String deviceId = md5(android_id).toUpperCase();
    //return deviceId;
    return "0";
}

public static final String md5(final String s) {
    try {
        // Create MD5 Hash
        MessageDigest digest = java.security.MessageDigest
                .getInstance("MD5");
        digest.update(s.getBytes());
        byte messageDigest[] = digest.digest();

        // Create Hex String
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < messageDigest.length; i++) {
            String h = Integer.toHexString(0xFF & messageDigest[i]);
            while (h.length() < 2)
                h = "0" + h;
            hexString.append(h);
        }
        return hexString.toString();

    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    return ";
}
  }
}

package examples.BrokenHash; 
public class class_1021 { 
public String md5(String s) {
    if (s != null)
    {
        try { // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest .getInstance("MD5");
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
    return ";
}

}
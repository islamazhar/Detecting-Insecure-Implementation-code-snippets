package examples.AllCodeSnippets; 
public class class_706{ 
 public static void main() { 
private String hashString(String s) {
        try {
            // Create SHA-1 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(s.getBytes("UTF-8"));
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return ";
    }
  }
}

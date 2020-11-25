package examples.AllCodeSnippets; 
public class class_364{ 
 public static void main() { 
public static String SHA256 (String text) throws NoSuchAlgorithmException {

    MessageDigest md = MessageDigest.getInstance("SHA-256");

    md.update(text.getBytes());
    byte[] digest = md.digest();

    return Base64.encodeToString(digest, Base64.DEFAULT);
}
  }
}

package examples.AllCodeSnippets; 
public class class_1292{ 
 public static void main() { 
    SecretKeyFactory keyFactory = null;
    try
    {
        keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    } 
    catch (NoSuchAlgorithmException e)
  }
}

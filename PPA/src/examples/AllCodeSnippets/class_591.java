package examples.AllCodeSnippets; 
public class class_591{ 
 public static void main() { 
MessageDigest digest = MessageDigest.getInstance("SHA-256");
digest.update(yourPassword.getBytes("UTF-8"));
String passwordEncrypted = Base64.encodeToString(digest.digest(), Base64.DEFAULT);
  }
}

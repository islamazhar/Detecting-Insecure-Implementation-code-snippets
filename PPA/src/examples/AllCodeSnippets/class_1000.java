package examples.AllCodeSnippets; 
public class class_1000{ 
 public static void main() {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(inputPassword.getBytes());
		byte[] hashedPassword = digest.digest();
  }
}

package examples.AllCodeSnippets; 
public class class_601{ 
 public static void main() { 
String password = "123456"; 
MessageDigest md = MessageDigest.getInstance("SHA-256"); 
md.update(password.getBytes()); 
byte byteData[] = md.digest();
  }
}

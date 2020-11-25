package examples.AllCodeSnippets; 
public class class_74{ 
 public static void main() { 
Key key = keyStore.getKey(alias, password.toCharArray());
String encodedKey = new Base64Encoder().encode(key.getEncoded());
System.out.println("key ? " + encodedKey);
  }
}

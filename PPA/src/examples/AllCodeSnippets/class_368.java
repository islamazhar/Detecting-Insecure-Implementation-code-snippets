package examples.AllCodeSnippets; 
public class class_368{ 
 public static void main() { 
MessageDigest digester = MessageDigest.getInstance("MD5");
byte[] bytes = new byte[8192];
int byteCount;
while ((byteCount = in.read(bytes)) > 0) {
  digester.update(bytes, 0, byteCount);
}
byte[] digest = digester.digest();
  }
}

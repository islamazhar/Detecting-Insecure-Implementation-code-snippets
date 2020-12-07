package examples.BrokenHash; 
public class class_369 { 
MessageDigest digester = MessageDigest.getInstance("MD5");
byte[] bytes = new byte[8192];
int byteCount;
while ((byteCount = in.read(bytes)) > 0) {
  digester.update(bytes, 0, byteCount);
}
byte[] digest = digester.digest();

}
package examples.AES; 
public class class_106 { 
MessageDigest md = MessageDigest.getInstance("MD5");
try (InputStream is = Files.newInputStream(Paths.get("file.txt"))) {
  DigestInputStream dis = new DigestInputStream(is, md);
  /* Read stream to EOF as normal... */
}
byte[] digest = md.digest();

}
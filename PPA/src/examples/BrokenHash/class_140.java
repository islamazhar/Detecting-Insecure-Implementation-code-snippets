package examples.BrokenHash; 
public class class_140 { 
MessageDigest md = MessageDigest.getInstance("MD5");
InputStream is = new FileInputStream("file.txt");
try {
    is = new DigestInputStream(is, md);
    // read stream to EOF as normal...
}
finally {
  is.close();
}
byte[] digest = md.digest();

}
package examples.AllCodeSnippets; 
public class class_1174{ 
 public static void main() { 
public byte[] getMD5(String fileAContents) throws NoSuchAlgorithmException {
     MessageDigest messageDigest = MessageDigest.getInstance("MD5");
     messageDigest.update(fileAContents.getBytes());
     return messageDigest.digest();
}
  }
}

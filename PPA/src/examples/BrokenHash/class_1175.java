package examples.BrokenHash; 
public class class_1175 { 
public byte[] getMD5(String fileAContents) throws NoSuchAlgorithmException {
     MessageDigest messageDigest = MessageDigest.getInstance("MD5");
     messageDigest.update(fileAContents.getBytes());
     return messageDigest.digest();
}

}
package examples.AES; 
public class class_692 { 
public String StringToMD5(String s) {
 try {
     // Create MD5 Hash
     MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
     digest.update(s.getBytes());
     byte messageDigest[] = digest.digest();

    // Create Hex String
     StringBuffer hexString = new StringBuffer();
     for (int i=0; i<messageDigest.length; i++)
            M hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
    return hexString.toString();

} catch (NoSuchAlgorithmException e) {
    e.printStackTrace();
}
return ";
}

}
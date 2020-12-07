package examples.BrokenHash; 
public class class_596 { 
MessageDigest md = null;
String digest = null;
    try {
        md = MessageDigest.getInstance("MD5");

        byte[] hash = md.digest(myStringToEncode.getBytes("UTF-8")); //converting byte array to Hexadecimal String
        StringBuilder sb = new StringBuilder(2*hash.length);

        for(byte b : hash){
            sb.append(String.format("%02x", b&0xff));
        }

        digest = sb.toString();

    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }

return digest;

}
package examples.AllCodeSnippets; 
public class class_1236{ 
 public static void main() { 
    public String computeFingerPrint(final byte[] certRaw) {

    String strResult = ";

    MessageDigest md;
    try {
        md = MessageDigest.getInstance("SHA1");
        md.update(certRaw);
        for (byte b : md.digest()) {
            strResult += Integer.toString(b & 0xff, 16);
        }
        strResult = strResult.toUpperCase(DATA_LOCALE);
    }
    catch (NoSuchAlgorithmException ex) {
        ex.printStackTrace();
    }

    return strResult;
}
  }
}

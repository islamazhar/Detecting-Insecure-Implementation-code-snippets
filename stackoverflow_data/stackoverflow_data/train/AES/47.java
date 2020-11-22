// 3
class User {
    @DatabaseField(canBeNull = false)
    private String passwordHash;

    public void setPassword(String password) {
        this.passwordHash = hashPassword(password);
    }

    public boolean isPasswordCorrect(String givenPassword) {
        return TextUtils.equals(hasPassword(givenPassword), passwordHash);
    }

    private String hashPassword(String password) {
        return AeSimpleSHA1.SHA1(password);
    }
}

public class AeSimpleSHA1 { 

    private static String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i &lt; data.length; i++) { 
            int halfbyte = (data[i] &gt;&gt;&gt; 4) &amp; 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 &lt;= halfbyte) &amp;&amp; (halfbyte &lt;= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] &amp; 0x0F;
            } while(two_halfs++ &lt; 1);
        } 
        return buf.toString();
    } 

    public static String SHA1(String text) 
    throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
        MessageDigest md;
        md = MessageDigest.getInstance("SHA-1");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    } 
} 

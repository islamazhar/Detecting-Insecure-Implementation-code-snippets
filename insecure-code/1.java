// 4 insecure: uses AES

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SimpleCrypto {

        public String encrypt(String seed, String cleartext) throws Exception {
                byte[] rawKey = getRawKey(seed.getBytes());
                byte[] result = encrypt(rawKey, cleartext.getBytes());
                return toHex(result);
        }

        public String decrypt(String seed, String encrypted) throws Exception {
                byte[] rawKey = getRawKey(seed.getBytes());
                byte[] enc = toByte(encrypted);
                byte[] result = decrypt(rawKey, enc);
                return new String(result);
        }

        // done
        private byte[] getRawKey(byte[] seed) throws Exception {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
                sr.setSeed(seed);
                kgen.init(128, sr); // 192 and 256 bits may not be available
                SecretKey skey = kgen.generateKey();
                byte[] raw = skey.getEncoded();
                return raw;
        }

        private byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
                SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                /*
                Suggested secure implmentation
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                */
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
                byte[] encrypted = cipher.doFinal(clear);
                return encrypted;
        }

        private byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
                SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, skeySpec);
                byte[] decrypted = cipher.doFinal(encrypted);
                return decrypted;
        }

        public String toHex(String txt) {
                return toHex(txt.getBytes());
        }

        public String fromHex(String hex) {
                return new String(toByte(hex));
        }

public  byte[] toByte(String hexString) {
        int len = hexString.length()/2;
        byte[] result = new byte[len];
        for (int i = 0; i &lt; len; i++)
                result[i] = Integer.valueOf(hexString.substring(2*i, 2*i+2), 16).byteValue();
        return result;
}

public  String toHex(byte[] buf) {
        if (buf == null)
                return "";
        StringBuffer result = new StringBuffer(2*buf.length);
        for (int i = 0; i &lt; buf.length; i++) {
                appendHex(result, buf[i]);
        }
        return result.toString();
}

        private final static String HEX = "0123456789ABCDEF";

private  void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b&gt;&gt;4)&amp;0x0f)).append(HEX.charAt(b&amp;0x0f));
}

}

package examples.AES; 
public class class_1110 { 
public static String encrypt(String seed, String cleartext) throws Exception {
Â  Â  Â  Â  Â  Â  Â  Â byte[] rawKey = getRawKey(seed.getBytes("UTF-16"));
Â  Â  Â  Â  Â  Â  Â  Â byte[] result = encrypt(rawKey, cleartext.getBytes("UTF-16"));
Â  Â  Â  Â  Â  Â  Â  Â return toHex(result);
Â  Â  Â  Â }
Â  Â  Â  Â 
Â  Â  Â  Â public static String decrypt(String seed, String encrypted) throws Exception {
Â  Â  Â  Â  Â  Â  Â  Â byte[] rawKey = getRawKey(seed.getBytes("UTF-16"));
Â  Â  Â  Â  Â  Â  Â  Â byte[] enc = toByte(encrypted);
Â  Â  Â  Â  Â  Â  Â  Â byte[] result = decrypt(rawKey, enc);
Â  Â  Â  Â  Â  Â  Â  Â return new String(result);
Â  Â  Â  Â  Â  Â  Â Â }

Â  Â  Â  Â private static byte[] getRawKey(byte[] seed) throws Exception {
Â  Â  Â  Â  Â  Â  Â  Â KeyGenerator kgen = KeyGenerator.getInstance("AES");
Â  Â  Â  Â  Â  Â  Â  Â SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
Â  Â  Â  Â  Â  Â  Â  Â sr.setSeed(seed);
Â  Â  Â  Â  Â  Â kgen.init(128, sr); // 192 and 256 bits may not be available
Â  Â  Â  Â  Â  Â SecretKey skey = kgen.generateKey();
Â  Â  Â  Â  Â  Â byte[] raw = skey.getEncoded();
Â  Â  Â  Â  Â  Â return raw;
Â  Â  Â  Â }

Â  Â  Â  Â 
Â  Â  Â  Â private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
Â  Â  Â  Â  Â  Â SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
Â  Â  Â  Â  Â  Â  Â  Â Cipher cipher = Cipher.getInstance("AES");
Â  Â  Â  Â  Â  Â cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
Â  Â  Â  Â  Â  Â byte[] encrypted = cipher.doFinal(clear);
Â  Â  Â  Â  Â  Â  Â  Â return encrypted;
Â  Â  Â  Â }

Â  Â  Â  Â private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
Â  Â  Â  Â  Â  Â SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
Â  Â  Â  Â  Â  Â  Â  Â Cipher cipher = Cipher.getInstance("AES");
Â  Â  Â  Â  Â  Â cipher.init(Cipher.DECRYPT_MODE, skeySpec);
Â  Â  Â  Â  Â  Â byte[] decrypted = cipher.doFinal(encrypted);
Â  Â  Â  Â  Â  Â  Â  Â return decrypted;
Â  Â  Â  Â }

Â  Â  Â  Â public static String toHex(String txt) {
Â  Â  Â  Â  Â  Â  Â  Â return toHex(txt.getBytes());
Â  Â  Â  Â }
Â  Â  Â  Â public static String fromHex(String hex) {
Â  Â  Â  Â  Â  Â  Â  Â return new String(toByte(hex));
Â  Â  Â  Â }
Â  Â  Â  Â 
Â  Â  Â  Â public static byte[] toByte(String hexString) {
Â  Â  Â  Â  Â  Â  Â  Â int len = hexString.length()/2;
Â  Â  Â  Â  Â  Â  Â  Â byte[] result = new byte[len];
Â  Â  Â  Â  Â  Â  Â  Â for (int i = 0; i < len; i++)
Â  Â  Â  Â  Â  Â  Â  Â  Â  Â  Â  Â result[i] = Integer.valueOf(hexString.substring(2*i, 2*i+2), 16).byteValue();
Â  Â  Â  Â  Â  Â  Â  Â return result;
Â  Â  Â  Â }

Â  Â  Â  Â public static String toHex(byte[] buf) {
Â  Â  Â  Â  Â  Â  Â  Â if (buf == null)
Â  Â  Â  Â  Â  Â  Â  Â  Â  Â  Â  Â return "";
Â  Â  Â  Â  Â  Â  Â  Â StringBuffer result = new StringBuffer(2*buf.length);
Â  Â  Â  Â  Â  Â  Â  Â for (int i = 0; i < buf.length; i++) {
Â  Â  Â  Â  Â  Â  Â  Â  Â  Â  Â  Â appendHex(result, buf[i]);
Â  Â  Â  Â  Â  Â  Â  Â }
Â  Â  Â  Â  Â  Â  Â  Â return result.toString();
Â  Â  Â  Â }
Â  Â  Â  Â private final static String HEX = "0123456789ABCDEF";
Â  Â  Â  Â private static void appendHex(StringBuffer sb, byte b) {
Â  Â  Â  Â  Â  Â  Â  Â sb.append(HEX.charAt((b>>4)&0x0f)).append(HEX.charAt(b&0x0f));
Â  Â  Â  Â }
Â  Â  Â  Â 

}
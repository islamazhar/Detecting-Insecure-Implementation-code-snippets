package examples.AES; 
public class class_1314 { 
public static String getHmac(String entity, String salt) throws Exception{
    Mac mac = Mac.getInstance("HmacSHA256");
    mac.init(new SecretKeySpec(salt.getBytes(), "HmacSHA1"));
    byte[] bs = mac.doFinal(entity.getBytes());
    return new HexDumpEncoder().encode(bs); // use your favorite hex converter
}

}
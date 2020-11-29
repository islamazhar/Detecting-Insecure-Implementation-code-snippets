package examples.AES; 
public class class_967 { 
KeyGenerator keygen = KeyGenerator.getInstance("AES");
SecureRandom secrand = SecureRandom.getInstance("SHA1PRNG");
secrand.setSeed(seed.getBytes());
keygen.init(128, secrand);
SecretKey seckey = keygen.generateKey();
byte[] rawKey = seckey.getEncoded();

}
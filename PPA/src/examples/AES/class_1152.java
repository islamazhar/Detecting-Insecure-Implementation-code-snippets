package examples.AES; 
public class class_1152 { 
KeyGenerator kgen = KeyGenerator.getInstance("AES");
kgen.init(KEY_SIZE);
SecretKey skey = kgen.generateKey();

}
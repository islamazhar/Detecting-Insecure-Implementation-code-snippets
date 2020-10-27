package test.ppa;
public class F {
    SecretKey key = SecretKeyFactory.getInstance( "PBEWithMD5AndDES").generateSecret(keySpec);    
}

package examples.AllCodeSnippets; 
public class class_927{ 
 public static void main() { 
SecretKeyFactory factory = 
    SecretKeyFactory.getInstance("PBEWITHSHAAND256BITAES-CBC-BC");
KeySpec spec = new PBEKeySpec("password".toCharArray(), salt, 1024, 256);
SecretKey tmp = factory.generateSecret(spec);
SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
  }
}

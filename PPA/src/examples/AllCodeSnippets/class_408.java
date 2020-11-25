package examples.AllCodeSnippets; 
public class class_408{ 
 public static void main() { 
    String getMD5(String data){
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(data.getBytes());
        return new BigInteger(1, m.digest()).toString(16);
    }
  }
}

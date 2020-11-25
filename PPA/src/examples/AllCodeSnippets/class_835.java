package examples.AllCodeSnippets; 
public class class_835{ 
 public static void main() { 
public byte[] digest(String value) throws NoSuchAlgorithmException {
    MessageDigest digester = MessageDigest.getInstance("SHA-256");

    byte[] stringBytes = value.getBytes();

    digester.update(stringBytes, 0, stringBytes.length);

    return digester.digest();
}
  }
}

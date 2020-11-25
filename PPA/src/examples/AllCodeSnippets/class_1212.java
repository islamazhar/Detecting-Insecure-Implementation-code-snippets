package examples.AllCodeSnippets; 
public class class_1212{ 
 public static void main() { 
byte[] iv = "87654321".getBytes("US-ASCII");
byte[] key = "SampleKey".getBytes("US-ASCII");
byte[] data = new byte[30]; // for example

SecretKeySpec skeySpec = new SecretKeySpec(key, "RC2");

RC2ParameterSpec ivSpec = new RC2ParameterSpec(key.length * 8, iv);

Cipher cipher = Cipher.getInstance("RC2/CBC/PKCS5Padding");
cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivSpec);
byte[] encrypted = cipher.doFinal(data);

// ....
  }
}

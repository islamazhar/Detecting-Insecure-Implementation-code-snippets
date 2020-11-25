package examples.AllCodeSnippets; 
public class class_1151{ 
 public static void main() { 
KeyGenerator kgen = KeyGenerator.getInstance("AES");
kgen.init(KEY_SIZE);
SecretKey skey = kgen.generateKey();
  }
}

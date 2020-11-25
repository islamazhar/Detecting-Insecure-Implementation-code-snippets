package examples.AllCodeSnippets; 
public class class_1266{ 
 public static void main() { 
    for (Signature signature : info.signatures) {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
    }
  }
}

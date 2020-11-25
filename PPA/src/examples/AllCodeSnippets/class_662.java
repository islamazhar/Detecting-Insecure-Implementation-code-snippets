package examples.AllCodeSnippets; 
public class class_662{ 
 public static void main() { 
try {
    PackageInfo info = getPackageManager().getPackageInfo(
            "com.example.packagename", 
            PackageManager.GET_SIGNATURES);
    for (Signature signature : info.signatures) {
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(signature.toByteArray());
        Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
        }
} catch (NameNotFoundException e) {
  e.printStackTrace();

} catch (NoSuchAlgorithmException e) {
    e.printStackTrace();
}
  }
}

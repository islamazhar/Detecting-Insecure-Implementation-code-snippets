package examples.AllCodeSnippets; 
public class class_936{ 
 public static void main() { 
try {
    PackageInfo info = getPackageManager().getPackageInfo(
            "your.package.name", 
            PackageManager.GET_SIGNATURES);
    for (Signature signature : info.signatures) {
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(signature.toByteArray());
        Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
        }
} catch (NameNotFoundException e) {
} catch (NoSuchAlgorithmException e) {
}
  }
}

package examples.AllCodeSnippets; 
public class class_1315{ 
 public static void main() { 
try {
PackageInfo info = getPackageManager().getPackageInfo("com.facebook.scrumptious", PackageManager.GET_SIGNATURES);
for (Signature signature : info.signatures) {
    MessageDigest md = MessageDigest.getInstance("SHA");
    md.update(signature.toByteArray());
    Log.e("MY KEY HASH:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
}
} catch (NameNotFoundException e) {

} catch (NoSuchAlgorithmException e) {

}
  }
}

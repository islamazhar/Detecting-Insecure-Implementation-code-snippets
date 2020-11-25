package examples.AllCodeSnippets; 
public class class_220{ 
 public static void main() { 
public static String getKeyHash(Context context, String packageName) {
try {
    PackageInfo info = context.getPackageManager().getPackageInfo(
            packageName,
            PackageManager.GET_SIGNATURES);
    for (Signature signature : info.signatures) {
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(signature.toByteArray());
        String keyHash = Base64.encodeToString(md.digest(), Base64.DEFAULT);
        return keyHash;
    }
} catch (PackageManager.NameNotFoundException e) {
    return null;
} catch (NoSuchAlgorithmException e) {
    return null;
}
return null;
  }
}

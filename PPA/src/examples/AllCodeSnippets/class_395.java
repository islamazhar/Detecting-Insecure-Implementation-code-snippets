package examples.AllCodeSnippets; 
public class class_395{ 
 public static void main() { 
 public static void generateKeyHash(Context context) {
    try {
        PackageInfo info = context.getPackageManager().getPackageInfo(
                "com.example.user2.testapp",
                PackageManager.GET_SIGNATURES);
        for (Signature signature : info.signatures) {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
        }
    } catch (PackageManager.NameNotFoundException e) {

    } catch (NoSuchAlgorithmException e) {

    }
}
  }
}

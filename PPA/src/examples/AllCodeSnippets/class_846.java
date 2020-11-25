package examples.AllCodeSnippets; 
public class class_846{ 
 public static void main() { 
public void printHashKey() {

   // Add code to print out the key hash
    try {
        PackageInfo info = getPackageManager().getPackageInfo("com.facebook.samples.hellofacebook", 
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

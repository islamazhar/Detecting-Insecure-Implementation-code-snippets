package examples.AllCodeSnippets; 
public class class_950{ 
 public static void main() { 
try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    "com.mypackage.name", 
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
                }
        } catch (NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
  }
}

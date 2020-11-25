package examples.AllCodeSnippets; 
public class class_400{ 
 public static void main() { 
try {
        PackageInfo info = getPackageManager().getPackageInfo(
                  "com.example.webwerks.facebookintegartiondemoapp",
        PackageManager.GET_SIGNATURES);
        for (android.content.pm.Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
  }
}
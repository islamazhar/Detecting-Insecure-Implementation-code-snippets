package examples.AllCodeSnippets; 
public class class_698{ 
 public static void main() { 
try {
        PackageInfo info = getPackageManager().getPackageInfo(
                "com.matainja.facebooklogin", 
                PackageManager.GET_SIGNATURES);
        for (Signature signature : info.signatures) {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
    } catch (NameNotFoundException e) {

    } catch (NoSuchAlgorithmExceptio`enter code here`n e) {

    }
  }
}

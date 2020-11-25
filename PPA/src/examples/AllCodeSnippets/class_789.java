package examples.AllCodeSnippets; 
public class class_789{ 
 public static void main() { 
try {
        PackageInfo info = getPackageManager().getPackageInfo(
//                 "Your package name", 
                PackageManager.GET_SIGNATURES);
        for (Signature signature : info.signatures) {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            Log.d("Your Tag", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
    } catch (NameNotFoundException e) {

    } catch (NoSuchAlgorithmException e) {

    }
  }
}

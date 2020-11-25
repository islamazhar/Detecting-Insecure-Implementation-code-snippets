package examples.AllCodeSnippets; 
public class class_1067{ 
 public static void main() { 
try {
            PackageInfo info = getPackageManager().getPackageInfo("com.your_package_name",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("YOURHASH KEY:",
                        Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
  }
}

package examples.AllCodeSnippets; 
public class class_902{ 
 public static void main() { 
    try {
        PackageInfo info = getPackageManager().getPackageInfo("my.package.name", PackageManager.GET_SIGNATURES);
        for (Signature signature : info.signatures) {
            MessageDigest md;
            md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            Log.e("hash key", Base64.encodeToString(md.digest(), Base64.DEFAULT));
        }
    } catch (NameNotFoundException e1) {
        Log.e("name not found", e1.toString());
    } catch (NoSuchAlgorithmException e) {
        Log.e("no such an algorithm", e.toString());
    } catch (Exception e) {
        Log.e("exception", e.toString());
    }
  }
}

package examples.AllCodeSnippets; 
public class class_44{ 
 public static void main() { 
private void getHashKey() {

    try {
        PackageInfo info = getPackageManager().getPackageInfo(
                "your_package_name", PackageManager.GET_SIGNATURES);
        for (Signature signature : info.signatures) {
            MessageDigest md = MessageDigest.getInstance("SHA"); 
            md.update(signature.toByteArray());
            Log.e("YOURHASH KEY:",
                    Base64.encodeToString(md.digest(),Base64.DEFAULT));
            String WEATHER_HASH = Base64.encodeToString(md.digest(),
                    Base64.DEFAULT);

            return;
        }
    } catch (NameNotFoundException e) {

    } catch (NoSuchAlgorithmException e) {

    }
    return;

}
  }
}

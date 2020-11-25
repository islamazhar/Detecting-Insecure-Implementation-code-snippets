package examples.AllCodeSnippets; 
public class class_454{ 
 public static void main() { 
  private void generateHashKey() {

        try {
            PackageInfo info = getPackageManager().getPackageInfo                       ("loginwith.gplush.android", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashCode  = Base64.encodeToString(md.digest(), Base64.DEFAULT);
                System.out.println("Print the hashKey for Facebook :"+hashCode);
                Log.d("KeyHash:", Base64.encodeToString(md.digest(),          Base64.DEFAULT));
            }
        } catch (NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
  }
}

package examples.AllCodeSnippets; 
public class class_487{ 
 public static void main() { 
 try
  {

        PackageInfo info = getPackageManager().getPackageInfo( "YOUR_PACKAGE_NAME", 
                PackageManager.GET_SIGNATURES);

        for (Signature signature : info.signatures) {
            MessageDigest md = MessageDigest.getInstance("SHA");

            md.update(signature.toByteArray());
            Log.i("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));//will give developer key hash
            Toast.makeText(getApplicationContext(),Base64.encodeToString(md.digest(), Base64.DEFAULT), Toast.LENGTH_LONG).show(); //will give app key hash or release key hash

            }
    } catch (NameNotFoundException e) {

    } catch (NoSuchAlgorithmException e) {

    }
  }
}

package examples.AllCodeSnippets; 
public class class_208{ 
 public static void main() { 
public void generateFacebookHashKey()
    {

        try
        {
//             PackageInfo info = getPackageManager().getPackageInfo("Your package name", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures)
            {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("TEMPTAGHASH KEY:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        }
        catch (NameNotFoundException e)
        {

        }
        catch (NoSuchAlgorithmException e)
        {

        }

    }
  }
}

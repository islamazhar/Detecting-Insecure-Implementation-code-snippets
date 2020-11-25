package examples.AllCodeSnippets; 
public class class_730{ 
 public static void main() { 
private void printHashKey()
{
    try
    {
        PackageInfo info = getPackageManager().getPackageInfo("com.your.package",
            PackageManager.GET_SIGNATURES);
        for (Signature signature: info.signatures)
        {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            Log.d("YOUR HASH KEY:",
                Base64.encodeToString(md.digest(), Base64.DEFAULT));
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

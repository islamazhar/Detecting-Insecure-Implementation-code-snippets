package examples.AllCodeSnippets; 
public class class_1192{ 
 public static void main() { 
static final String GetKey(Context context)
{
    String KeyHash = ";
    PackageInfo info;
    try {
        info = context.getPackageManager().getPackageInfo(context.getPackageName(),  PackageManager.GET_SIGNATURES);

        for (Signature signature : info.signatures)
        {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            KeyHash = Base64.encodeToString(md.digest(), Base64.DEFAULT);
        }

    } catch (NameNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return KeyHash;
}
  }
}

package examples.AllCodeSnippets; 
public class class_1120{ 
 public static void main() { 
    String TAG = "com.sromku.simple.fb.example";
        PackageInfo info = context.getPackageManager().getPackageInfo(TAG,
            PackageManager.GET_SIGNATURES);
        for (Signature signature: info.signatures)
        {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            String keyHash = Base64.encodeToString(md.digest(), Base64.DEFAULT);
            Log.d(TAG, "keyHash: " + keyHash);
  }
}

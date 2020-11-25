package examples.AllCodeSnippets; 
public class class_537{ 
 public static void main() { 
try {
    PackageInfo info = getPackageManager().getPackageInfo(
            "YOUR_PACKAGE_NAME", PackageManager.GET_SIGNATURES);
    for (Signature signature: info.signatures)  {
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(signature.toByteArray());
        Log.e("FACEBOOK APP SIGNATURE", Base64.encodeToString(md.digest(), Base64.DEFAULT));
    }
} catch (Exception e) {
    // TODO: handle exception
    e.printStackTrace();
}
  }
}

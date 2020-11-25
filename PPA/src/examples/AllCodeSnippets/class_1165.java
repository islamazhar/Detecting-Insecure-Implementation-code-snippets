package examples.AllCodeSnippets; 
public class class_1165{ 
 public static void main() { 
@Override
protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);

try {
    PackageInfo info = getPackageManager().getPackageInfo(
            getPackageName(), 
            PackageManager.GET_SIGNATURES);
    for (Signature signature : info.signatures) {
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(signature.toByteArray());
        Log.d("TAG", "Hash to copy ==> "+ Base64.encodeToString(md.digest(), Base64.DEFAULT));
        }
} catch (NameNotFoundException e) {

} 
catch (NoSuchAlgorithmException e) {

}
}
  }
}

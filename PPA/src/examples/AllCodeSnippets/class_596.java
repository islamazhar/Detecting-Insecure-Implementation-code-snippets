package examples.AllCodeSnippets; 
public class class_596{ 
 public static void main() { 
try {
        PackageInfo info = context.getPackageManager().getPackageInfo(
//                 "com.example.sharingapplication", PackageManager.GET_SIGNATURES); //Your            package name here
        for (Signature signature : info.signatures) {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            Log.i("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }

    } catch (NameNotFoundException e) {
    } catch (NoSuchAlgorithmException e) {
    }
}
  }
}

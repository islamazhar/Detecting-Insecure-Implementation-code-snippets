package examples.AllCodeSnippets; 
public class class_1305{ 
 public static void main() { 
try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;

                    md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    String something = new String(Base64.encode(md.digest(), 0));
                    Log.e("hash key", something);
        } 
        }
        catch (NameNotFoundException e1) {
            // TODO Auto-generated catch block
            Log.e("name not found", e1.toString());
        }

             catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                 Log.e("no such an algorithm", e.toString());
            }
             catch (Exception e){
                 Log.e("exception", e.toString());
             }
  }
}

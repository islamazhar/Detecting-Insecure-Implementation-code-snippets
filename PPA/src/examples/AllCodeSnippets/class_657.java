package examples.AllCodeSnippets; 
public class class_657{ 
 public static void main() { 
        PackageInfo packageInfo;
        String key = null;
        try {
//             //getting application package name, as defined in manifest
            String packageName = context.getApplicationContext().getPackageName();

//             //Retriving package info
            packageInfo = context.getPackageManager().getPackageInfo(packageName,
                    PackageManager.GET_SIGNATURES);

            MyLog.e("Package Name=", context.getApplicationContext().getPackageName());

            for (Signature signature : packageInfo.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                key = new String(Base64.encode(md.digest(), 0));

                // String key = new String(Base64.encodeBytes(md.digest()));
                MyLog.e("Key Hash=", key);
            }
        } catch (NameNotFoundException e1) {
            MyLog.e("Name not found", e1.toString());
        }
        catch (NoSuchAlgorithmException e) {
            MyLog.e("No such an algorithm", e.toString());
        } catch (Exception e) {
            MyLog.e("Exception", e.toString());
        }
  }
}

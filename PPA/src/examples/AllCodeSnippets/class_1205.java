package examples.AllCodeSnippets; 
public class class_1205{ 
 public static void main() { 
PackageInfo packageInfo = context.getPackageManager().getPackageInfo(
    context.getPackageName(), PackageManager.GET_SIGNATURES);

for (Signature signature : packageInfo.signatures) {
    byte[] signatureBytes = signature.toByteArray();
    MessageDigest md = MessageDigest.getInstance("SHA");
    md.update(signature.toByteArray());
    final String currentSignature = Base64.encodeToString(md.digest(), Base64.DEFAULT);
    if (SIGNATURE.equals(currentSignature)){
      return true;
    }
}
return fals;
  }
}

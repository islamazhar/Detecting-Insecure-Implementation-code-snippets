package examples.AllCodeSnippets; 
public class class_5{ 
 public static void main() { 
PackageInfo pi = packageManager.getPackageInfo(getPackageName());
byte[] certificate = pi.signatures[0].toByteArray();
MessageDigest md = MessageDigest.getInstance("MD5");
byte[] fingerprint = md.digest(certificate);
String hexFingerprint = toHexString(fingerprint);
  }
}

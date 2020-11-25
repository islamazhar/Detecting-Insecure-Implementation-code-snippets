package examples.AllCodeSnippets; 
public class class_928{ 
 public static void main() { 
int bks_version;
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
    bks_version = R.raw.publickey; //The BKS file
} else {
    bks_version = R.raw.publickey_v1; //The BKS (v-1) file
}
KeyStore ks = KeyStore.getInstance("BKS");
InputStream in = getResources().openRawResource(bks_version);  
ks.load(in, "mypass".toCharArray());
  }
}

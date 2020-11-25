package examples.AllCodeSnippets; 
public class class_775{ 
 public static void main() { 
KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
try {
FileInputStream fis = ctx.getApplicationContext().openFileInput("bs.keystore");
ks.load(fis, ksPassword);
} catch(FileNotFoundException e) {
    ks.load(null, ksPassword);
}
  }
}

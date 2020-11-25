package examples.AllCodeSnippets; 
public class class_27{ 
 public static void main() { 
KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

// get user password and file input stream
char[] password = "password of the keystore in the file system";

java.io.FileInputStream fis = null;
try {
    fis = new java.io.FileInputStream("keyStoreName");
    ks.load(fis, password);
} finally {
    if (fis != null) {
        fis.close();
    }
}
  }
}

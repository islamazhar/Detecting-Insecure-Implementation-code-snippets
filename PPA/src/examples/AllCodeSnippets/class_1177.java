package examples.AllCodeSnippets; 
public class class_1177{ 
 public static void main() { 
InputStream keyStoreStream = ontext.openFileInput ( filename );
KeyStore keyStore = KeyStore.getInstance ( KeyStore.getDefaultType ( ) );
keyStore.load ( keyStoreStream, oldPass );
FileOutputStream fileOutputStream = context.openFileOutput ( filename, Context.MODE_PRIVATE );
keystore.store ( fileOutputStream, newPassword );
fileOutputStream.close ( );
  }
}
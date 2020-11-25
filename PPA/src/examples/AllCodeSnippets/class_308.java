package examples.AllCodeSnippets; 
public class class_308{ 
 public static void main() { 
KeyStore store = KeyStore.getInstance("BKS");
InputStream in;
try {
    in = App.getInstance().getApplicationContext().openFileInput(filename);
        try {
            store.load(in, password);
        } finally {
            in.close();
        }
    } catch (FileNotFoundException e) {
        //create new keystore
        store.load(null, password);
    }
  }
}

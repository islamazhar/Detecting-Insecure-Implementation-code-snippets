package examples.AllCodeSnippets; 
public class class_1001{ 
 public static void main() { 
KeyStore trusted = KeyStore.getInstance("BKS");
InputStream in = context.getResources().openRawResource(R.raw.mystore);
trusted.load(in, "mypassword".toCharArray());
in.close();
SSLSocketFactory mySslFact = new SSLSocketFactory(trusted);
  }
}

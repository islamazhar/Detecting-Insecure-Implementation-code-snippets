package examples.AllCodeSnippets; 
public class class_1264{ 
 public static void main() { 
String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
tmf.init(keyStore);
  }
}

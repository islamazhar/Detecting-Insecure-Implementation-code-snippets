package examples.AllCodeSnippets; 
public class class_1200{ 
 public static void main() { 
KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
kmf.init(null, null);
KeyManager km = kmf.getKeyManagers()[0];

ftpsClient = new FTPSClient("SSL");
ftpsClient.setKeyManager(km);
  }
}

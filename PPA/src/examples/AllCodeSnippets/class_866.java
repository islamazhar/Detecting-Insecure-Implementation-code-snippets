package examples.AllCodeSnippets; 
public class class_866{ 
 public static void main() { 
SSLSocketFactory ssf = sc.getSocketFactory(); 
SSLSocket s = (SSLSocket) ssf.createSocket(serverip, serverport);
s.startHandshake();
  }
}

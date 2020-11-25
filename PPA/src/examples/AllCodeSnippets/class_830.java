package examples.AllCodeSnippets; 
public class class_830{ 
 public static void main() { 
final Socket tcpSocket = SSLSocketFactory.getDefault().createSocket("host ip", 443);
String connect = "custom CONNECT header";

tcpSocket.getOutputStream().write((connect).getBytes());
tcpSocket.getOutputStream().flush();
  }
}

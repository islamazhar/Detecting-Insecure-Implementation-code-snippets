package examples.AllCodeSnippets; 
public class class_1030{ 
 public static void main() { 
SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
SSLSocket socket = (SSLSocket) factory.createSocket(domain, 443);

socket.startHandshake();
BufferedReader in = new BufferedReader(new InpuStreamReader(socket.getInputStream()));
PrintWriter out = new PrintWriter(socket.getOutputStream());
  }
}

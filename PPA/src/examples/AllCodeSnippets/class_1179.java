package examples.AllCodeSnippets; 
public class class_1179{ 
 public static void main() { 
        SocketFactory sf = SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) sf.createSocket("host-name", 443);
        socket.setEnabledProtocols(new String[] { "TLSv1"});
        socket.startHandshake();
  }
}

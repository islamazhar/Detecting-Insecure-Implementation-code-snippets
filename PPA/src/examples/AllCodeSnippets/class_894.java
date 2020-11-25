package examples.AllCodeSnippets; 
public class class_894{ 
 public static void main() { 
import javax.net.ssl.SSLSocketFactory;

// Create a socket without connecting
SSLSocketFactory socketFactory = SSLSocketFactory.getDefault();
Socket socket = socketFactory.createSocket();

// Connect, with an explicit timeout value
socket.connect(new InetSocketAddress(endpoint.mServer,
endpoint.mPort), CONNECT_TIMEOUT);
  }
}

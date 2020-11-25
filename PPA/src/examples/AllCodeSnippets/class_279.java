package examples.AllCodeSnippets; 
public class class_279{ 
 public static void main() { 
private void AdjustSocket(Socket socket)
{
    String[] protocols = ((SSLSocket) socket).getSSLParameters().getProtocols();
    ArrayList<String> protocolList = new ArrayList<String>(Arrays.asList(protocols));

    for (int ii = protocolList.size() - 1; ii >= 0; --ii )
        {
        if ((protocolList.get(ii).contains("TLSv1.1")) || (protocolList.get(ii).contains("TLSv1.2")))
            protocolList.remove(ii);
        }

    protocols = protocolList.toArray(new String[protocolList.size()]);
    ((SSLSocket)socket).setEnabledProtocols(protocols);
}
  }
}

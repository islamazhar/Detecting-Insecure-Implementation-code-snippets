package examples.AllCodeSnippets; 
public class class_319{ 
 public static void main() { 
    XMPPTCPConnectionConfiguration.Builder config = XMPPTCPConnectionConfiguration.builder();
    config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
    config.setUsernameAndPassword(USER_ID+ "@" + DOMAIN, key);
    config.setServiceName(DOMAIN);
    config.setHost(DOMAIN);
    config.setPort(PORT);
    config.setDebuggerEnabled(true);
    config.setSocketFactory(SSLSocketFactory.getDefault());

    mConnection = new XMPPTCPConnection(config.build());
    try {
        mConnection.connect();
    } catch (SmackException | IOException | XMPPException e) {
        e.printStackTrace();
    }
  }
}

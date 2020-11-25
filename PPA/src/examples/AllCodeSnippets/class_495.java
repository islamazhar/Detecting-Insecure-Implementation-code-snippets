package examples.AllCodeSnippets; 
public class class_495{ 
 public static void main() { 
class MyKeyManager implements X509KeyManager {

    private final X509KeyManager keyManager;

    MyKeyManager(X509KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    @DebugLog
    @Override
    public String chooseClientAlias(String[] strings, Principal[] principals, Socket socket) {
        return this.keyManager.chooseClientAlias(strings, principals, socket);
    }

    @DebugLog
    @Override
    public String chooseServerAlias(String s, Principal[] principals, Socket socket) {
        return keyManager.chooseServerAlias(s, principals, socket);
    }

    @DebugLog
    @Override
    public X509Certificate[] getCertificateChain(String s) {
        return keyManager.getCertificateChain(s);
    }

    @DebugLog
    @Override
    public String[] getClientAliases(String s, Principal[] principals) {
        return keyManager.getClientAliases(s, principals);
    }

    @DebugLog
    @Override
    public String[] getServerAliases(String s, Principal[] principals) {
        return keyManager.getServerAliases(s, principals);
    }

    @DebugLog
    @Override
    public PrivateKey getPrivateKey(String s) {
        return keyManager.getPrivateKey(s);
    }
}
  }
}

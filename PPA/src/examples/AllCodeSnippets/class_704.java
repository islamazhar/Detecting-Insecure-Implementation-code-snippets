package examples.AllCodeSnippets; 
public class class_704{ 
 public static void main() { 
 /**
 * Initialize the HTTP/S connection (if needed)
 *
 * @param  keystoreFile  the full path of the keystore file
 * @param  keystorePass  the password for the keystore file
 */
private void initHttps(String keystoreFile, String keystorePass)
{
    // check if the URL uses HTTP/S
    if (url.toLowerCase().startsWith(HTTPS_PROTOCOL))
    {
        print("Initializing HTTP/S protocol...");
        // set the system properties needed for HTTP/S
        System.setProperty("javax.net.ssl.keyStore", keystoreFile);
        System.setProperty("javax.net.ssl.keyStorePassword", keystorePass);
        System.setProperty("javax.net.ssl.keyStoreType", "JKS");
        System.setProperty("javax.net.ssl.trustStore", keystoreFile);
        System.setProperty("javax.net.ssl.trustStorePassword", keystorePass);
        System.setProperty("javax.protocol.handler.pkgs",
            "com.sun.net.ssl.internal.www.protocol");
        //int addProvider = Security.addProvider(new       com.sun.net.ssl.internal.ssl.Provider());
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier()
        {   // fix a HTTP/S handshake issue
            public boolean verify(String hostName, SSLSession session)
            {   // Verify that the host name is acceptable 
                return true;
            }
        });
    }
}
  }
}

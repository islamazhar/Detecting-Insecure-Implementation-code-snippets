package examples.AllCodeSnippets; 
public class class_550{ 
 public static void main() { 
WifiConfiguration wc = new WifiConfiguration();
wc.SSID = "\"your_ssid\";
wc.allowedKeyManagement.set(KeyMgmt.WPA_EAP);
wc.allowedKeyManagement.set(KeyMgmt.IEEE8021X);
wc.enterpriseConfig.setEapMethod(Eap.TLS);
wc.status = WifiConfiguration.Status.ENABLED;

...

KeyStore pkcs12ks = KeyStore.getInstance("pkcs12");

in = new BufferedInputStream(new FileInputStream(new File("/path/to/your.p12")));
// alternatively you can read from any input stream, e.g. ByteArrayInputStream to read from String

pkcs12ks.load(in, "pasword".toCharArray());

Enumeration<String> aliases = pkcs12ks.aliases();
while (aliases.hasMoreElements()) {
    String alias = aliases.nextElement();
    Log.d(TAG, "Processing alias " + alias);

    X509Certificate cert = (X509Certificate) pkcs12ks.getCertificate(alias);
    Log.d(TAG, cert.toString());

    PrivateKey key = (PrivateKey) pkcs12ks.getKey(alias, "password".toCharArray());
    Log.d(TAG, key.toString());

    wc.enterpriseConfig.setClientKeyEntry(key, cert);
    wc.enterpriseConfig.setIdentity("WiFi-1");
}

...

int netID = wifiManager.addNetwork(wc);
wifiManager.saveConfiguration();
wifiManager.enableNetwork(netID, true);
  }
}

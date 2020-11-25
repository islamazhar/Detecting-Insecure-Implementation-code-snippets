package examples.AllCodeSnippets; 
public class class_158{ 
 public static void main() { 
/**
 * Android Central Keystore repo usually located on /data/misc/keychain 
 * including the system trusted anchors located on /system/etc/security
 */
KeyStore keyStore = KetStore.getInstance("AndroidCAStore");
keyStore.load(null, null); //Load default system keystore
Enumeration<String> keyAliases = keyStore.aliases();

while(keyAliases.hasMoreElements()){
    String alias = aliases.nextElement();
    X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias);

    //<User cert in whatever way you want>
}
  }
}

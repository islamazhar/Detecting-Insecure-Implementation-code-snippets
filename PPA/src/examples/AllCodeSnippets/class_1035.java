package examples.AllCodeSnippets; 
public class class_1035{ 
 public static void main() { 
KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

try (FileInputStream fis = new FileInputStream(keystore)) {
    ks.load(fis, ksPw.toCharArray());
}

ks.getEntry(alias, new KeyStore.PasswordProtection(aliasPw.toCharArray()));
  }
}

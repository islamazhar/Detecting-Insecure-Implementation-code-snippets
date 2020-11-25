package examples.AllCodeSnippets; 
public class class_1261{ 
 public static void main() { 
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    Cipher cipher = null;
    TextView tv = new TextView(this);
    setContentView(tv);

    for (String name : SYMMETRIC_CIPHERS) {
    try {
        cipher = Cipher.getInstance(name, "BC");
        tv.append(name);
        tv.append("\n");
    } catch (Exception e) {
    }
    }
}
  }
}

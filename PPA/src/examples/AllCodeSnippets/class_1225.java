package examples.AllCodeSnippets; 
public class class_1225{ 
 public static void main() { 
final Charset charset = Charset.forName("UTF-8");
final MessageDigest digest = MessageDigest
        .getInstance("SHA-512");
final byte[] hashData = digest
        .digest(json.getBytes(charset));
final String hash = new String(hashData, charset);
nameValuePairs.add(new BasicNameValuePair("credit_card", hash));
  }
}

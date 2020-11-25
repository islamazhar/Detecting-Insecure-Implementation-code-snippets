package examples.AllCodeSnippets; 
public class class_754{ 
 public static void main() { 
/**
 * @param input
 * @return decoded string
 */
public static String decode(String input) {
    // Receiving side
    String text = ";
    try {
        byte[] data = Decoder.decode(input);
        text = new String(data, "UTF-8");
        return text;
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    return "Error";
}
  }
}

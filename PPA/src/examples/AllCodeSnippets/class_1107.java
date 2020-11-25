package examples.AllCodeSnippets; 
public class class_1107{ 
 public static void main() { 
// Implementing a fromString method on an enum type
private static final Map<String, Operation> stringToEnum = new HashMap<String, Operation>();
static { // Initialize map from constant name to enum constant
    for (Operation op : values())
        stringToEnum.put(op.toString(), op);
} // Returns Operation for string, or null if string is invalid
public static Operation fromString(String symbol) {
    return stringToEnum.get(symbol);
}
  }
}

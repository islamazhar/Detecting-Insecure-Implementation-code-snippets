package examples.AllCodeSnippets; 
public class class_1311{ 
 public static void main() { 
// NOTE could replace Principal w/ Spring Security's Authentication object too
// Just be careful you don't expose the password over REST!
@RequestMapping(value="/user",produces = "application/json")
public Map<String,String> helloUser(Principal principal) {
    HashMap<String,String> result = new HashMap<String,String>();
    result.put("username", principal.getName());
    return result;
}
  }
}

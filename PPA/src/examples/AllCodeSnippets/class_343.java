package examples.AllCodeSnippets; 
public class class_343{ 
 public static void main() { 
public static Direction parseString(String direction){
    if(direction != null){
        //trim the input since I never trust user input
        direction = direction.trim();

        for(Direction d : Direction.values()){
            if(d.toString().equalsIgnoreCase(direction)){
                return d;
            }
        }
    }

    return null;
}
  }
}

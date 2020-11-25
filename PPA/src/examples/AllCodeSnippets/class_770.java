package examples.AllCodeSnippets; 
public class class_770{ 
 public static void main() { 
        Data before = new Data();
        before.setName("Joseph Wallflower");
        before.setNameOperation(new UpperCaseStringOperation());
        before.setEmail("Joseph.Wallflower@SomeCompany.com");
        before.setEmailOperation(new LowerCaseStringOperation());

        System.out.format("BEFORE: %s%n", before.toString());

        Serializer serializer = new Persister();
        File file = new File(System.getenv("USERPROFILE")+File.separator+"Documents"+File.separator+"simple.xml");
        serializer.write(before, file);
  }
}

package examples.AllCodeSnippets; 
public class class_1104{ 
 public static void main() { 
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

//method to convert Document to String
public String getStringFromDocument(Document doc)
{
    try
    {
       DOMSource domSource = new DOMSource(doc);
       StringWriter writer = new StringWriter();
       StreamResult result = new StreamResult(writer);
       TransformerFactory tf = TransformerFactory.newInstance();
       Transformer transformer = tf.newTransformer();
       transformer.transform(domSource, result);
       return writer.toString();
    }
    catch(TransformerException ex)
    {
       ex.printStackTrace();
       return null;
    }
}
  }
}

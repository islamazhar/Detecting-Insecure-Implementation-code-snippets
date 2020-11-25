package examples.AllCodeSnippets; 
public class class_52{ 
 public static void main() { 
private static final String CLASS_NAME = "SendQueryTask";
//...
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
//...
private String transformXmlToString(Node node)
{
    Transformer transformer = null;
    try
    {
        transformer = TransformerFactory.newInstance().newTransformer();
    }
    catch (TransformerConfigurationException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (TransformerFactoryConfigurationError e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    if ( transformer != null )
    {
        transformer.setOutputProperty( OutputKeys.INDENT, "yes" );

        // initialize StreamResult with File object to save to file
        StreamResult result = new StreamResult( new StringWriter() );
        DOMSource source = new DOMSource( node );

        try
        {
            transformer.transform( source, result );
        }
        catch (TransformerException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String xmlString = result.getWriter().toString();
        Log.i( CLASS_NAME, "flattened=" + (xmlString) );

        return xmlString;
    }       
    return null;
}
  }
}

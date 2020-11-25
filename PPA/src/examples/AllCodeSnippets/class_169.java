package examples.AllCodeSnippets; 
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;


public class class_169
{
    private static String serializeDocument(Document doc)
    {
        String xml = null;
        try
        {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            Properties outFormat = new Properties();
            outFormat.setProperty( OutputKeys.INDENT, "yes" );
            outFormat.setProperty( OutputKeys.METHOD, "xml" );
            outFormat.setProperty( OutputKeys.OMIT_XML_DECLARATION, "no" );
            outFormat.setProperty( OutputKeys.VERSION, "1.0" );
            outFormat.setProperty( OutputKeys.ENCODING, "UTF-8" );
            transformer.setOutputProperties( outFormat );

            DOMSource domSource = new DOMSource( doc.getDocumentElement() );
            OutputStream output = new StringOutputStream();
            StreamResult result = new StreamResult( output );
            transformer.transform( domSource, result );

            xml = output.toString();
            android.util.Log.i( "XMLHELPER", xml );
        }
        catch (TransformerConfigurationException e)
        {
            android.util.Log.d( "XMLHELPER", "Exception: " + e );
            e.printStackTrace();
        }
        catch (TransformerException e)
        {
            android.util.Log.d( "XMLHELPER", "Exception: " + e );
            e.printStackTrace();
        }

        return xml;
    }
}

package examples.AllCodeSnippets; 
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Some general XML functions
 */
public class class_1056
{
    /**
     * Get an XML Document file from its string representation
     * @param xml The xml string
     * @return Document object for the XML representation
     */
    public static Document fromString(String xml)
    {
        if (xml == null)
            throw new NullPointerException("The xml string passed in is null");

        // from http://www.rgagnon.com/javadetails/java-0573.html
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));

            Document doc = db.parse(is);

            return doc;
        }
        catch (SAXException e)
        {
            return null;
        }
        catch(Exception e)
        {
            CustomExceptionHandler han = new CustomExceptionHandler();
            han.uncaughtException(Thread.currentThread(), e);
            return null;
        }
    }

    /**
     * Get a XML Document object from a file
     * @param location The location where the file is found
     * @return An XML Document object
     */
    public static Document fromFile(String location)
    {
        return fromFile(new File(location));
    }

    /**
     * Get a XML Document object from a file
     * @param location The file object to load
     * @return An XML Document object
     */
    public static Document fromFile(File file)
    {
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            return doc;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * Method to convert Document to String
     * @param doc
     * @return
     */
    public static String getStringFromDocument(Document doc)
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

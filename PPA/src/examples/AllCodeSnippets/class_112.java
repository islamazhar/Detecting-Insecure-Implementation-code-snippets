package examples.AllCodeSnippets; 
public class class_112{ 
 public static void main() { 
private static void xmlParser() {
    try {
        String filepath = "yourfile.xml";
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(filepath);
        // Get the root element
        Node min = doc.getElementsByTagName("poem").item(0);
        NamedNodeMap attr = min.getAttributes();
                    // get the value of the name=
        Node nodeAttr = attr.getNamedItem("name");
                    //if you want to change the value of the name use 
                    nodeAttr.setTextContent("new name value");
                    //if you want to get the value between >value< use 
                    nodeAttr.getTextContent()
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filepath));
        transformer.transform(source, result);
    } catch (ParserConfigurationException e) {
            e.printStackTrace();
    }
     catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        } catch (TransformerConfigurationException e) {

            e.printStackTrace();
        } catch (TransformerException e) {

            e.printStackTrace();
        }
}
  }
}

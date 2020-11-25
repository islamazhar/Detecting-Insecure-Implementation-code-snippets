package examples.AllCodeSnippets; 
public class class_224{ 
 public static void main() { 
private void addNewObject(String fiQty, String fiUnWeight, String fiTotWeight, String lotBin) {

    try {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("root");
        doc.appendChild(rootElement);

        // elements
        Element obj = doc.createElement("object");
        rootElement.appendChild(obj);

        Element fiQtyE = doc.createElement("fiQty");
        fiQtyE.appendChild(doc.createTextNode(fiQty));
        obj.appendChild(fiQtyE);
        //  elements
        Element fiUnWeightE = doc.createElement("fiUnWeight");
        fiUnWeightE.appendChild(doc.createTextNode(fiUnWeight));
        obj.appendChild(fiUnWeightE);

        Element fiTotWeightE = doc.createElement("fiTotWeight");
        fiTotWeightE.appendChild(doc.createTextNode(fiTotWeight));
        obj.appendChild(fiTotWeightE);

        //  elements
        Element lotBinE = doc.createElement("lotBin");
        lotBinE.appendChild(doc.createTextNode(lotBin));
        obj.appendChild(lotBinE);

        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        StreamResult result = new StreamResult(new File(Config.FILE_NAME));//your dir file

        // Output to console for testing
        // StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);

        System.out.println("File saved!");

    } catch (ParserConfigurationException pce) {
        pce.printStackTrace();
    } catch (TransformerException tfe) {
        tfe.printStackTrace();
    }

}
  }
}

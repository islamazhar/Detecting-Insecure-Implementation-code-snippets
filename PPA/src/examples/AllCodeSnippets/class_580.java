package examples.AllCodeSnippets; 
public class class_580{ 
 public static void main() { 
DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
 dbfac.setNamespaceAware(true);
 DocumentBuilder docBuilder = null;
 try {
    docBuilder = dbfac.newDocumentBuilder();
} catch (ParserConfigurationException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
 DOMImplementation domImpl = docBuilder.getDOMImplementation();
 Document doc = domImpl.createDocument("http://coggl.com/InsertTrack","TrackEntry", null);
 doc.setXmlVersion("1.0");
 doc.setXmlStandalone(true);

 Element trackElement = doc.getDocumentElement();

 Element CompanyId = doc.createElement("CompanyId");
 CompanyId.appendChild(doc.createTextNode("1"));
 trackElement.appendChild(CompanyId);

 Element CreatedBy = doc.createElement("CreatedBy");
 CreatedBy.appendChild(doc.createTextNode("6"));
 trackElement.appendChild(CreatedBy);

 Element DepartmentId = doc.createElement("DepartmentId");
 DepartmentId.appendChild(doc.createTextNode("4"));
 trackElement.appendChild(DepartmentId);

 Element IsBillable = doc.createElement("IsBillable");
 IsBillable.appendChild(doc.createTextNode("1"));
 trackElement.appendChild(IsBillable);

 Element ProjectId = doc.createElement("ProjectId");
 ProjectId.appendChild(doc.createTextNode("1"));
 trackElement.appendChild(ProjectId);

 Element StartTime = doc.createElement("StartTime");
 StartTime.appendChild(doc.createTextNode("2012-03-14 10:44:45"));
 trackElement.appendChild(StartTime);

 Element StopTime = doc.createElement("StopTime");
 StopTime.appendChild(doc.createTextNode("2012-03-14 11:44:45"));
 trackElement.appendChild(StopTime);

 Element TaskId = doc.createElement("TaskId");
 TaskId.appendChild(doc.createTextNode("3"));
 trackElement.appendChild(TaskId);

 Element TotalTime = doc.createElement("TotalTime");
 TotalTime.appendChild(doc.createTextNode("1"));
 trackElement.appendChild(TotalTime);

 Element TrackDesc = doc.createElement("TrackDesc");
 TrackDesc.appendChild(doc.createTextNode("dello testing"));
 trackElement.appendChild(TrackDesc);

 Element TrackId = doc.createElement("TrackId");
 TrackId.appendChild(doc.createTextNode("0"));
 trackElement.appendChild(TrackId);

 TransformerFactory transfac = TransformerFactory.newInstance();
 Transformer trans = null;
try {
    trans = transfac.newTransformer();
} catch (TransformerConfigurationException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
 trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
 trans.setOutputProperty(OutputKeys.INDENT, "yes");

 //create string from xml tree
 StringWriter sw = new StringWriter();
 StreamResult result = new StreamResult(sw);
 DOMSource source = new DOMSource(doc);
 try {
    trans.transform(source, result);
} catch (TransformerException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
 String xmlString = sw.toString();

//posting xml file to server

 DefaultHttpClient httpClient = new DefaultHttpClient();

 HttpPost httppost = new HttpPost("http://192.168.0.19:3334/cogglrestservice.svc/InsertTrack");     
 // Make sure the server knows what kind of a response we will accept
 httppost.addHeader("Accept", "text/xml");
 // Also be sure to tell the server what kind of content we are sending
 httppost.addHeader("Content-Type", "application/xml");

 try
 {
 StringEntity entity = new StringEntity(xmlString, "UTF-8");
 entity.setContentType("application/xml");
 httppost.setEntity(entity);

 // execute is a blocking call, it's best to call this code in a thread separate from the ui's
 HttpResponse response = httpClient.execute(httppost);

 BasicResponseHandler responseHandler = new BasicResponseHandler();
    String strResponse = null;
    if (response != null) {
        try {
            strResponse = responseHandler.handleResponse(response);
        } catch (HttpResponseException e) {
            e.printStackTrace();  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Log.e("WCFTEST", "WCFTEST ********** Response" + strResponse);    


 }
 catch (Exception ex)
 {
 ex.printStackTrace();
 }
 Toast.makeText(EditTask.this, "Xml posted succesfully.",Toast.LENGTH_SHORT).show();
  }
}

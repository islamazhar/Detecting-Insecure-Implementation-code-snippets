package examples.AllCodeSnippets; 
import java.io.*;
import javax.xml.parsers.*;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

import org.w3c.dom.*;

import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.utils.Constants;
import org.apache.xml.security.utils.XMLUtils;

enter code here

public class class_1004 {
    boolean verifySignature() {
    boolean valid = false;
    try {
        // parse the XML
        InputStream in = obtainInputStreamToXMLSomehow();
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setNamespaceAware(true);
        Document doc = f.newDocumentBuilder().parse(in);
        in.close();

        // verify signature
        NodeList nodes = doc.getElementsByTagNameNS(Constants.SignatureSpecNS, "Signature");
        if (nodes.getLength() == 0) {
        throw new Exception("Signature NOT found!");
        }

        Element sigElement = (Element) nodes.item(0);
        XMLSignature signature = new XMLSignature(sigElement, ");

        KeyInfo ki = signature.getKeyInfo();
        if (ki == null) {
        throw new Exception("Did not find KeyInfo");
        }

        X509Certificate cert = signature.getKeyInfo().getX509Certificate();
        if (cert == null) {
        PublicKey pk = signature.getKeyInfo().getPublicKey();
        if (pk == null) {
            throw new Exception("Did not find Certificate or Public Key");
        }
        valid = signature.checkSignatureValue(pk);
        }
        else {
        valid = signature.checkSignatureValue(cert);
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }

    return valid;
    }

    // This is important!
    static {
    org.apache.xml.security.Init.init();
    }
}

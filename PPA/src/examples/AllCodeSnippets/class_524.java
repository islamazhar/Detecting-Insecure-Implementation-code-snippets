package examples.AllCodeSnippets; 
import java.io.File;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

public class class_524 extends Activity {

    private static String TAG = XsltTester.class.getSimpleName();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        try {

            Source xmlSource = new StreamSource(this.getResources().openRawResource(R.raw.weather));
            Source xsltSource = new StreamSource(this.getResources().openRawResource(R.raw.weatherxsl));

            TransformerFactory transFact = TransformerFactory.newInstance();
            Transformer trans = transFact.newTransformer(xsltSource);
//          FileOutputStream fo = new FileOutputStream(f);
//          fo.write(resizeBitMapImageToByteArray(photoAlbumBean));
//          fo.close();
            File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/mydata.html");

//            OutputStream output = new StringOutputStream();
            StreamResult result = new StreamResult(f);
            trans.transform(xmlSource, result);

        } catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

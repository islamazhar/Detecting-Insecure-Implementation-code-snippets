package examples.AllCodeSnippets; 
import android.app.Application;
import java.security.Security;
public class class_418 extends Application {
    static { Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1); }
}

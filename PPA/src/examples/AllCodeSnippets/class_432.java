package examples.AllCodeSnippets; 
public class class_432{ 
 public static void main() { 
final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
             public boolean verify1(String hostname, SSLSession session) {
                 return true;
             }

            @Override
            public boolean verify(String arg0, SSLSession arg1) {
                // TODO Auto-generated method stub
                return false;
            }
      };
  }
}

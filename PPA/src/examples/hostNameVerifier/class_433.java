package examples.hostNameVerifier; 
public class class_433 { 
final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
             public boolean verify1(String hostname, SSLSession session) {
                 return true;
             }

            
            public boolean verify(String arg0, SSLSession arg1) {
                // TODO Auto-generated method stub
                return false;
            }
      };

}
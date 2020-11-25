package examples.AllCodeSnippets; 
public class class_768{ 
 public static void main() { 
        File file=new File(getApplicationContext().getPackageCodePath());  
        FileInputStream input = new FileInputStream(file);
        ByteArrayOutputStream output = new ByteArrayOutputStream ();
        byte [] buffer = new byte [65536];
        int l;
        while ((l = input.read (buffer)) > 0)
               output.write (buffer, 0, l);
        input.close ();
        output.close ();
        byte [] data = output.toByteArray ();
        MessageDigest digest = MessageDigest.getInstance( "SHA-1" );
        byte[] bytes = data;
        digest.update(bytes, 0, bytes.length);
        bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for( byte b : bytes )
           sb.append( String.format("%02X", b) );
        hash = sb.toString();
  }
}

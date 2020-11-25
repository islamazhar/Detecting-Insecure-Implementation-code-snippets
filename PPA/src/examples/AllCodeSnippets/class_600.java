package examples.AllCodeSnippets; 
public class class_600{ 
 public static void main() { 
String _publicKey= base64encoded_publickey;


    // InputStream fileInputStream = null;
    try {
        // Receiving side

        byte[] decodedBytes = Base64.decode(_publicKey, Base64.DEFAULT);

        fileInputStream = new ByteArrayInputStream(decodedBytes);

        // Print the decoded string

        String decodedString = new String(decodedBytes);


        CertificateFactory certFactory = CertificateFactory
                .getInstance(CERTIFICATE_TYPE);
        // certFactory.
        X509Certificate cert = (X509Certificate) certFactory
                .generateCertificate(fileInputStream);
        publicKey = cert.getPublicKey();
        Log.d("TAG", "Public key of the certificate:" + publicKey);


    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Could not intialize encryption module",
                e);
    } finally {
        if (keyStream != null) {
            try {
                keyStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
  }
}

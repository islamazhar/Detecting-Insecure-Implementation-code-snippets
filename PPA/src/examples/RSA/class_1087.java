package examples.RSA; 
public class class_1087 { 
/**
 * 
 * @param PEMString  -A file/string in .pem format with a generated RSA key (with "des3", using "openssl genrsa".)
 * @param isFilePath - If it's a file path or a string
 * @return java.security.PublicKey
 * @throws IOException -No key found
 * @throws NoSuchAlgorithmException 
 * @throws InvalidKeySpecException 
 * 
 * @author hsigmond
 */

private static PublicKey getPublicKeyFromPemFormat(String PEMString,
        boolean isFilePath) throws IOException, NoSuchAlgorithmException,
        InvalidKeySpecException {

    BufferedReader pemReader = null;
    if (isFilePath) {
        pemReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(PEMString)));
    } else {
        pemReader = new BufferedReader(new InputStreamReader(
                new ByteArrayInputStream(PEMString.getBytes("UTF-8"))));
    }
    StringBuffer content = new StringBuffer();
    String line = null;
    while ((line = pemReader.readLine()) != null) {
        if (line.indexOf("-----BEGIN PUBLIC KEY-----") != -1) {
            while ((line = pemReader.readLine()) != null) {
                if (line.indexOf("-----END PUBLIC KEY") != -1) {
                    break;
                }
                content.append(line.trim());
            }
            break;
        }
    }
    if (line == null) {
        throw new IOException("PUBLIC KEY" + " not found");
    }
Log.i("PUBLIC KEY: ", "PEM content = : " + content.toString());

    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    return keyFactory.generatePublic(new X509EncodedKeySpec(Base64.decode(content.toString(), Base64.DEFAULT)));

}

}
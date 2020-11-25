package examples.AllCodeSnippets; 
public class class_135{ 
 public static void main() { 
public void saveToFile(String fileName, BigInteger mod, BigInteger exp)
        throws IOException {
    ObjectOutputStream oout = new ObjectOutputStream(
            new BufferedOutputStream(new FileOutputStream(fileName)));
    try {
        oout.writeObject(mod);
        oout.writeObject(exp);
    } catch (Exception e) {
        throw new IOException("Unexpected error", e);
    } finally {
        oout.close();
    }
}

PublicKey ReadPublicKeyFromFile(String keyFileName) throws IOException {
    InputStream in = RSACrypt.class.getClassLoader().getResourceAsStream(keyFileName);
    ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(
            in));
    try {
        BigInteger m = (BigInteger) oin.readObject();
        BigInteger e = (BigInteger) oin.readObject();
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        PublicKey pubKey = fact.generatePublic(keySpec);
        return pubKey;
    } catch (Exception e) {
        throw new RuntimeException("Spurious serialisation error", e);
    } finally {
        oin.close();
    }
}
  }
}

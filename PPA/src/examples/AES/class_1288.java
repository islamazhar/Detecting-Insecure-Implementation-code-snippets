package examples.AES; 
public class class_1288 { 
public static void main(String[] args) throws DataLengthException, IllegalStateException, InvalidCipherTextException {

    // just some constants
    boolean ENCRYPT = true;
    boolean DECRYPT = false;

    // the key is either in binary in PHP or a string (dynamic isn't it?), lets assume ASCII
    byte[] givenKey = args[0].getBytes(Charset.forName("ASCII"));

    // determine the key size dynamically, somebody thought this was a good idea...
    // NOTE: PHP will emit a warning if the key size is larger, but will simply use the
    // largest key size otherwise
    final int keysize;
    if (givenKey.length <= 128 / Byte.SIZE) {
        keysize = 128;
    } else if (givenKey.length <= 192 / Byte.SIZE) {
        keysize = 192;
    } else {
        keysize = 256;
    }

    // create a 256 bit key by adding zero bytes to the decoded key
    byte[] keyData = new byte[keysize / Byte.SIZE];
    System.arraycopy(givenKey, 0, keyData, 0, Math.min(givenKey.length, keyData.length));
    KeyParameter key = new KeyParameter(keyData);

    // create a Rijndael cipher with 256 bit block size, this is not AES
    BlockCipher rijndael = new RijndaelEngine(256);

    // use a padding method that only works on data that cannot end with zero valued bytes
    ZeroBytePadding c = new ZeroBytePadding();

    // use ECB mode encryption, which should never be used
    PaddedBufferedBlockCipher pbbc = new PaddedBufferedBlockCipher(rijndael, c);

    // initialize the cipher using the key (no need for an IV, this is ECB)
    pbbc.init(ENCRYPT, key);

    // create a plain text byte array
    byte[] plaintext = args[1].getBytes(Charset.forName("UTF8"));

    // create a buffer for the ciphertext
    byte[] ciphertext = new byte[pbbc.getOutputSize(plaintext.length)];

    int offset = 0;
    offset += pbbc.processBytes(plaintext, 0, plaintext.length, ciphertext, offset);
    offset += pbbc.doFinal(ciphertext, offset);

    // show the ciphertext
    System.out.println(new String(Hex.encode(ciphertext), Charset.forName("ASCII")));

    // reverse the encryption
    pbbc.init(DECRYPT, key);
    byte[] decrypted = new byte[pbbc.getOutputSize(ciphertext.length)];
    offset = 0;
    offset += pbbc.processBytes(ciphertext, 0, ciphertext.length, decrypted, offset);
    offset += pbbc.doFinal(decrypted, offset);

    // this will probably print out correctly, but it isn't actually correct
    System.out.println(new String(decrypted, Charset.forName("UTF8")));

    // check out the zero's at the end
    System.out.println(new String(Hex.encode(decrypted), Charset.forName("UTF8")));

    // so lets make it a bit shorter... the PHP way
    // note that in PHP, the string may *not* contain a null terminator
    // add it yourself before printing the string
    System.out.println(new String(decrypted, Charset.forName("UTF8")).replaceAll("\\x00+$", ""));
}

}
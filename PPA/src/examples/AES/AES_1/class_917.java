package examples.AESALL; 
public class class_917 {

private static String TAG = "MyCrypter";

public MyCrypter() {

}

/**
 * Encodes a String in AES-128 with a given key
 * 
 * @param context
 * @param password
 * @param text
 * @return String Base64 and AES encoded String
 * @throws NoPassGivenException
 * @throws NoTextGivenException
 */
public String encode(Context context, String password, String text)
        throws NoPassGivenException, NoTextGivenException {
    if (password.length() == 0 || password == null) {
        throw new NoPassGivenException("Please give Password");
    }

    if (text.length() == 0 || text == null) {
        throw new NoTextGivenException("Please give text");
    }

    try {
        SecretKeySpec skeySpec = getKey(password);
        byte[] clearText = text.getBytes("UTF8");

        //IMPORTANT TO GET SAME RESULTS ON iOS and ANDROID
        final byte[] iv = new byte[16];
        Arrays.fill(iv, (byte) 0x00);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        // Cipher is not thread safe
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);

        String encrypedValue = Base64.encodeToString(
                cipher.doFinal(clearText), Base64.DEFAULT);
        Log.d(TAG, "Encrypted: " + text + " -> " + encrypedValue);
        return encrypedValue;

    } catch (InvalidKeyException e) {
        e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (BadPaddingException e) {
        e.printStackTrace();
    } catch (NoSuchPaddingException e) {
        e.printStackTrace();
    } catch (IllegalBlockSizeException e) {
        e.printStackTrace();
    } catch (InvalidAlgorithmParameterException e) {
        e.printStackTrace();
    }
    return ";
}

/**
 * Decodes a String using AES-128 and Base64
 * 
 * @param context
 * @param password
 * @param text
 * @return desoded String
 * @throws NoPassGivenException
 * @throws NoTextGivenException
 */
public String decode(Context context, String password, String text)
        throws NoPassGivenException, NoTextGivenException {

    if (password.length() == 0 || password == null) {
        throw new NoPassGivenException("Please give Password");
    }

    if (text.length() == 0 || text == null) {
        throw new NoTextGivenException("Please give text");
    }

    try {
        SecretKey key = getKey(password);

        //IMPORTANT TO GET SAME RESULTS ON iOS and ANDROID
        final byte[] iv = new byte[16];
        Arrays.fill(iv, (byte) 0x00);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        byte[] encrypedPwdBytes = Base64.decode(text, Base64.DEFAULT);
        // cipher is not thread safe
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
        byte[] decrypedValueBytes = (cipher.doFinal(encrypedPwdBytes));

        String decrypedValue = new String(decrypedValueBytes);
        Log.d(TAG, "Decrypted: " + text + " -> " + decrypedValue);
        return decrypedValue;

    } catch (InvalidKeyException e) {
        e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (BadPaddingException e) {
        e.printStackTrace();
    } catch (NoSuchPaddingException e) {
        e.printStackTrace();
    } catch (IllegalBlockSizeException e) {
        e.printStackTrace();
    } catch (InvalidAlgorithmParameterException e) {
        e.printStackTrace();
    }
    return ";
}

/**
 * Generates a SecretKeySpec for given password
 * @param password
 * @return SecretKeySpec
 * @throws UnsupportedEncodingException
 */
public SecretKeySpec getKey(String password)
        throws UnsupportedEncodingException {


    int keyLength = 128;
    byte[] keyBytes = new byte[keyLength / 8];
    // explicitly fill with zeros
    Arrays.fill(keyBytes, (byte) 0x0);

    // if password is shorter then key length, it will be zero-padded
    // to key length
    byte[] passwordBytes = password.getBytes("UTF-8");
    int length = passwordBytes.length < keyBytes.length ? passwordBytes.length
            : keyBytes.length;
    System.arraycopy(passwordBytes, 0, keyBytes, 0, length);
    SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
    return key;
}

public class class_917 extends Exception {
    public NoTextGivenException(String message) {
        super(message);
    }

}

public class class_917 extends Exception {
    public NoPassGivenException(String message) {
        super(message);
    }

}

}

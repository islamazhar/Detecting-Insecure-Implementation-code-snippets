package examples.AES; 
public class class_1334 { 
try { 
                PackageInfo info =     getPackageManager().getPackageInfo("PROJECTNAME",     PackageManager.GET_SIGNATURES);
                for (Signature signature : info.signatures) {
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    String sign=Base64.encodeToString(md.digest(), Base64.DEFAULT);
                    Log.e("MY KEY HASH:", sign);
                    //textInstructionsOrLink = (TextView)findViewById(R.id.textstring);
                    //textInstructionsOrLink.setText(sign);
                    Toast.makeText(getApplicationContext(),sign,     Toast.LENGTH_LONG).show();
                }
    } catch (NameNotFoundException e) {
        Log.d("nope","nope");
    } catch (NoSuchAlgorithmException e) {
    }",3,0,6e8b3c458c1f3c3670e693a922e8d61469de8293a4dba76a95842ed55db2b315
public void encrypt() throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        // Here you read the cleartext.
        FileInputStream fis = new FileInputStream("data/cleartext");
        // This stream write the encrypted text. This stream will be wrapped by
        // another stream.
        FileOutputStream fos = new FileOutputStream("data/encrypted");

        // Length is 16 byte
        SecretKeySpec sks = new SecretKeySpec("yourkey".getBytes(), "AES");
        // Create cipher
        Cipher cipher = Cipher.getInstance("AES/CBC");
        cipher.init(Cipher.ENCRYPT_MODE, sks);
        // Wrap the output stream
        CipherOutputStream cos = new CipherOutputStream(fos, cipher);
        // Write bytes
        int b;
        byte[] d = new byte[8];
        while ((b = fis.read(d)) != -1) {
            cos.write(d, 0, b);
        }
        // Flush and close streams.
        cos.flush();
        cos.close();
        fis.close();
    }

}
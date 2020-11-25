package examples.AllCodeSnippets; 
public class class_940{ 
 public static void main() { 
public void decrypt(File inputFile, File outputFile, byte[] key) throws Exception {
        Cipher cipher = getCipherDecrypt(key);
        FileOutputStream fos = null;
        CipherInputStream cis = null;
        FileInputStream fis = null;
        try { 
            fis = new FileInputStream(inputFile);
            cis = new CipherInputStream(fis, cipher);
            fos = new FileOutputStream(outputFile);
            byte[] data = new byte[1024];
            int read = cis.read(data);
            while (read != -1) {
                fos.write(data, 0, read);
                read = cis.read(data);
                System.out.println(new String(data, "UTF-8").trim());
            } 
        } finally { 
            fos.close();
            cis.close();
            fis.close();
        } 
    } 
  }
}

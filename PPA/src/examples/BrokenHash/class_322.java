package examples.AES; 
public class class_322 { 
    System.out.println("start *****");

     String text="The quick brown fox jumps over the lazy dog"; 
     StandardPBEByteEncryptor encryptor=new StandardPBEByteEncryptor();     
     encryptor.setAlgorithm("PBEWithMD5AndDES"); 
     encryptor.setPassword("HelloWorld");      
     byte[] encrypted=encryptor.encrypt(text.getBytes()); 

    System.out.println("stop *****");

}
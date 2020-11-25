package examples.AllCodeSnippets; 
try {   
                   GmailSender sender = new GmailSender("gmailusername", "gmailpassword",");
                   sender.sendMail("Registration to Model Apps:","username="+username+"\n password="+password,"gmailusername","gmailusername");   
                } 
             catch (Exception e) 
               {   
                   Log.e("SendMail", e.getMessage(), e);   
               }



and create class  GmailSender

// package com.example.ur;//write ur pakage

import javax.activation.DataHandler;   
import javax.activation.DataSource;   
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;   
import javax.mail.PasswordAuthentication;   
import javax.mail.Session;   
import javax.mail.Transport;   
import javax.mail.internet.InternetAddress;   
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;   
import javax.mail.internet.MimeMultipart;

import android.util.Log;

import java.io.ByteArrayInputStream;   
import java.io.IOException;   
import java.io.InputStream;   
import java.io.OutputStream;   
import java.security.Security;   
import java.util.Properties;   

public class class_1218 extends javax.mail.Authenticator {   
    private String mailhost = "smtp.gmail.com",imagePath;   
    private String user;   
    private String password;   
    private Session session;   

    static 
    {   
        Security.addProvider(new com.example.model.JSSEProvider());   
    }  

    public GmailSender(String user, String password,String imagePath) {   
        this.user = user;   
        this.password = password;   
        this.imagePath=imagePath;
        Properties props = new Properties();   
        props.setProperty("mail.transport.protocol", "smtp");   
        props.setProperty("mail.host", mailhost);   
        props.put("mail.smtp.auth", "true");   


        props.put("mail.smtp.port", "465");   
        props.put("mail.smtp.socketFactory.port", "465");   
        props.put("mail.smtp.socketFactory.class",   
                "javax.net.ssl.SSLSocketFactory");   
        props.put("mail.smtp.socketFactory.fallback", "false");   
        props.setProperty("mail.smtp.quitwait", "false");   

        session = Session.getDefaultInstance(props, this);   
    }   

    protected PasswordAuthentication getPasswordAuthentication() {   
        return new PasswordAuthentication(user, password);   
    }   

    public synchronized void sendMail(String subject, String body, String sender, String recipients) throws Exception {   
        try{


             Transport transport = session.getTransport();  

             MimeMessage message = new MimeMessage(session);  
             message.setSubject(subject);  
             message.setFrom(new InternetAddress(sender));  
             message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipients));  

             //  
             // This HTML mail have to 2 part, the BODY and the embedded image  
             //  
             MimeMultipart multipart = new MimeMultipart("related");  

             // first part  (the html)  
             BodyPart messageBodyPart = new MimeBodyPart();  
             String htmlText = "<H1>"+body+"</H1>";  
             messageBodyPart.setContent(htmlText, "text/html");  

             // add it  
             multipart.addBodyPart(messageBodyPart);  

             // second part (the image)  
          //   messageBodyPart = new MimeBodyPart();  
         //    DataSource fds = new FileDataSource(imagePath);  
         //    messageBodyPart.setDataHandler(new DataHandler(fds));  
         //    messageBodyPart.setHeader("Content-ID",imagePath);  

             // add it  
           //  multipart.addBodyPart(messageBodyPart);  

             // put everything together  
             message.setContent(multipart);  

             transport.connect();  
             transport.sendMessage(message,message.getRecipients(Message.RecipientType.TO));  
             transport.close();  
        }catch(Exception e){
            Log.e(", "FILE NOT FOUND EXCEPTION "+e.getMessage());
        }
    }   

    public class class_1218 implements DataSource {   
        private byte[] data;   
        private String type;   

        public ByteArrayDataSource(byte[] data, String type) {   
            super();   
            this.data = data;   
            this.type = type;   
        }   

        public ByteArrayDataSource(byte[] data) {   
            super();   
            this.data = data;   
        }   

        public void setType(String type) {   
            this.type = type;   
        }   

        public String getContentType() {   
            if (type == null)   
                return "application/octet-stream";   
            else  
                return type;   
        }   

        public InputStream getInputStream() throws IOException {   
            return new ByteArrayInputStream(data);   
        }   

        public String getName() {   
            return "ByteArrayDataSource";   
        }   

        public OutputStream getOutputStream() throws IOException {   
            throw new IOException("Not Supported");   
        }   
    }   
}  

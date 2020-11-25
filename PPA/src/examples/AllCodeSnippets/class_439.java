package examples.AllCodeSnippets; 
public class class_439 extends javax.mail.Authenticator {   
    private String mailhost = "smtp.gmail.com";   
    private String user;   
    private String password;   
    private Session session;   

    static {   
        Security.addProvider(new com.provider.JSSEProvider());   
    }  

    public GmailSender(String user, String password) {   
        this.user = user;   
        this.password = password;   

        Properties props = new Properties();   
        props.put("mail.smtp.user", user);
        props.put("mail.smtp.auth", "true");   
        props.put("mail.smtp.host", mailhost);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");  
        props.put("mail.debug", "true");

        session = Session.getInstance(props, this);    
    }   

    protected PasswordAuthentication getPasswordAuthentication() {   
        return new PasswordAuthentication(user, password);   
    }   

    public synchronized void sendMail(String subject, String body, String sender, String recipients) throws Exception {   
        try{
            MimeMessage message = new MimeMessage(session);   
            DataHandler handler = new DataHandler(new ByteArrayDataSource(body.getBytes(), "text/plain"));   
            message.setSender(new InternetAddress(sender));   
            message.setSubject(subject);   
            message.setDataHandler(handler);   
            if (recipients.indexOf(',') > 0)   
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));   
            else  
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));   
            Transport t = session.getTransport("smtp");
            t.connect(mailhost, user, password);
            t.sendMessage(message, message.getAllRecipients());

        }catch(Exception e){
            e.printStackTrace();
        }
    }   

    public class class_439 implements DataSource {   
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

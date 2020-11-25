package examples.AllCodeSnippets; 
public class class_918 extends SSLSocketFactory {

    private SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    private Socket last;

    public void closeLastSocket() {
        if (last != null) {
            last.close();
        }
    }

    public Socket createSocket() throws IOException {
        return this.last = factory.createSocket();
    }

    ...

}

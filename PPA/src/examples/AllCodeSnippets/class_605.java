package examples.AllCodeSnippets; 
public class class_605{ 
 public static void main() { 
private static final int BUFFER_SIZE = 4096;
private static final char[] TERMINATOR = new char[]{'\r', '\n', '\r', '\n'};

/**
 * Simple SSL connect example to avoid Issue 15356 on Android 2.3.3
 *
 * @param host    The host/server name
 * @param port    The TCP port to use (443 is default for HTTP over SSL)
 * @param file    The file you are requesting (/path/to/file/on/server.doc)
 * @param fileOut Your <code>OutputStream</code> for the file you are writing to
 * @throws Exception If any error occurs - obviously should be improved for your implementation
 */
private static void downloadFileOverSSL(String host, int port, String file, OutputStream fileOut) throws Exception {
    PrintWriter socketOut = null;
    InputStream socketIn = null;
    try {
        // create a socket to talk to the server on
        SocketFactory factory = SSLSocketFactory.getDefault();
        Socket socket = factory.createSocket(host, port);

        // we'll use this to send our request to the server
        socketOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        //This is what Java was sending using URLConnection, and it works here too...
        //  You can always change this to something both your app and server will understand depending how it is setup
        // This is the least you need in the request:
        /*String requestStr = "GET " + file + " HTTP/1.1\r\n" +
            "Host: " + host + "\r\n" +
            "\r\n";*/
        String requestStr = "GET " + file + " HTTP/1.1\r\n" +
                "Host: " + host + "\r\n" +
                "User-Agent: Java/1.6.0_25\r\n" +
                "Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2" +
                "Connection: keep-alive\r\n" +
                "\r\n";
        //Log.i(getLogTag(), "Request being sent: `" + requestStr + "\");

        // send the request to the server
        socketOut.print(requestStr);
        socketOut.flush();

        // this reads the server's response
        socketIn = socket.getInputStream();

        /*
           Write the results into our local file's output stream
        */

        // This is the tricky part, the raw socket returns the HTTP 200 response and headers.
        // This can probably be optimized, but it's just reading through until it finds \r\n\r\n

        // You can use something like CharTerminatedInputStream
        //      (ref: http://www.java2s.com/Tutorial/Java/0180__File/AnInputStreamclassthatterminatesthestreamwhenitencountersaparticularbytesequence.htm)
        CharTerminatedInputStream charTermInput = new CharTerminatedInputStream(socketIn, TERMINATOR);
        while (charTermInput.read() != -1) {
            // -1 indicates a match was made, IOException or ProtocolException thrown if match not made by end of stream
        }

        int numBytesRead;
        byte[] buffer = new byte[BUFFER_SIZE];
        while ((numBytesRead = socketIn.read(buffer, 0, BUFFER_SIZE)) != -1) {
            fileOut.write(buffer, 0, numBytesRead);
            //Log.d(getLogTag(), "Reading data [" + numBytesRead + "]: " + new String(buffer, 0, numBytesRead));
        }
        fileOut.flush();

    } finally {
        safeClose(socketOut);
        safeClose(socketIn);
        safeClose(fileOut);
    }
}

private static void safeClose(Closeable closeable) {
    if (closeable != null) {
        try {
            closeable.close();
        } catch (IOException ioe) {
            //Log.w(getLogTag(), "Failed to close stream", ioe);
        }
    }
}
  }
}

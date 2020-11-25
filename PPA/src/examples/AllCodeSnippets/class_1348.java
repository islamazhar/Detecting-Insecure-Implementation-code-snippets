package examples.AllCodeSnippets; 
        SchemeRegistry schemeRegistry = new SchemeRegistry ();

        schemeRegistry.register (new Scheme ("http",
        PlainSocketFactory.getSocketFactory (), 80));
        schemeRegistry.register (new Scheme ("https",
        new CustomSSLSocketFactory (), 443));

        ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager (
           params, schemeRegistry);


         return new DefaultHttpClient (cm, params);
    }

    // CustomSSLSocketFactory:

       public class class_1348 extends org.apache.http.conn.ssl.SSLSocketFactory
         {
           private SSLSocketFactory FACTORY =  HttpsURLConnection.getDefaultSSLSocketFactory ();

        public CustomSSLSocketFactory ()
          {
            super(null);  
        try
           {
            SSLContext context = SSLContext.getInstance ("TLS");
            TrustManager[] tm = new TrustManager[] { new FullX509TrustManager () };
             context.init (null, tm, new SecureRandom ());

             FACTORY = context.getSocketFactory ();
          }
         catch (Exception e)
         {
              e.printStackTrace();
         }
    }

   public Socket createSocket() throws IOException
     {
        return FACTORY.createSocket();
      }

     // TODO: add other methods like createSocket() and getDefaultCipherSuites().
   // Hint: they all just make a call to member FACTORY 
}


   //FullX509TrustManager is a class that implements javax.net.ssl.X509TrustManager,    yet   none of the methods actually perform any work, get a sample here.

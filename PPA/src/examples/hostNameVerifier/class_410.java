package examples.hostNameVerifier; 
public class class_410 { 
public Client hostIgnoringClient() {
    try
    {
        SSLContext sslcontext = SSLContext.getInstance( "TLS" );
        sslcontext.init( null, null, null );
        DefaultClientConfig config = new DefaultClientConfig();
        Map<String, Object> properties = config.getProperties();
        HTTPSProperties httpsProperties = new HTTPSProperties(
                new HostnameVerifier()
                {
                    
                    public boolean verify( String s, SSLSession sslSession )
                    {
                        return true;
                    }
                }, sslcontext
        );
        properties.put( HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, httpsProperties );
        config.getClasses().add( JacksonJsonProvider.class );
        return Client.create( config );
    }
    catch ( KeyManagementException | NoSuchAlgorithmException e )
    {
        throw new RuntimeException( e );
    }
}

}
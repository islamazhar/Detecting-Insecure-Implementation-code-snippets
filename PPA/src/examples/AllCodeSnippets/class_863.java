package examples.AllCodeSnippets; 
public class class_863 implements X509TrustManager
{
    private AcceptUserSelectedCertsTrustManager(ValidateCertificateCallback callback) throws NoSuchAlgorithmException, KeyStoreException
    {
        KeyStore keyStore = null;
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        factory.init(keyStore);
        TrustManager [] trustmanagers = factory.getTrustManagers();
        m_standardTrustManager = (X509TrustManager) trustmanagers[0];
    }

    @Override
    public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException
    {
    }

    // This is where you check the server cert and make the determination
    @Override
    public void checkServerTrusted(X509Certificate[] certChain, String authType)throws CertificateException
    {
        try
        {
            m_standardTrustManager.checkServerTrusted(certChain,authType);
        }
        catch(CertificateException e)
        {
            // Cert isn't trusted - popup the error here. You'll need to 
            // make sure you switch to the UI thread since here you're on a network thread
            if(!userAcceptsCert(certChain))
            {
                throw e;
            }
        }
    }
}

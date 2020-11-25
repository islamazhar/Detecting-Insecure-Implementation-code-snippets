package examples.AllCodeSnippets; 
public class class_620{ 
 public static void main() { 
   this.client = new WebSocketClient(new SslContextFactory(true){
        @Override
        public void customize(SSLEngine sslEngine) {
            SSLParameters sslParams = sslEngine.getSSLParameters();
            //sslParams.setEndpointIdentificationAlgorithm(_endpointIdentificationAlgorithm);
            sslEngine.setSSLParameters(sslParams);

            if (getWantClientAuth())
                sslEngine.setWantClientAuth(getWantClientAuth());
            if (getNeedClientAuth())
                sslEngine.setNeedClientAuth(getNeedClientAuth());

            sslEngine.setEnabledCipherSuites(selectCipherSuites(
                    sslEngine.getEnabledCipherSuites(),
                    sslEngine.getSupportedCipherSuites()));

            sslEngine.setEnabledProtocols(selectProtocols(sslEngine.getEnabledProtocols(),sslEngine.getSupportedProtocols()));
        }
    });
  }
}

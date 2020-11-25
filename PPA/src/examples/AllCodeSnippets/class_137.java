package examples.AllCodeSnippets; 
public class class_137{ 
 public static void main() { 
    public void checkServerTrusted(X509Certificate[] certificates,String authType) throws CertificateException {
    if ((certificates != null) && LOG.isDebugEnabled()) {
        LOG.debug("Server certificate chain:");
        for (int i = 0; i < certificates.length; i++) {
            LOG.debug("X509Certificate[" + i + "]=" + certificates[i]);
        }
    }
    if ((certificates != null) && (certificates.length == 1)) {
        certificates[0].checkValidity();
    } else {
        List<X509Certificate> certs = new ArrayList<X509Certificate>();
        certs.addAll(Arrays.asList(certificates));
        X509Certificate certChain = certs.get(0);
        certs.remove(certChain);
        LinkedList<X509Certificate> chainList= new LinkedList<X509Certificate>();
        chainList.add(certChain);
        Principal certIssuer = certChain.getIssuerDN();
        Principal certSubject = certChain.getSubjectDN();
        while(!certs.isEmpty()){
            List<X509Certificate> tempcerts = new ArrayList<X509Certificate>();
            tempcerts.addAll(certs);
            for (X509Certificate cert : tempcerts){
                if(cert.getIssuerDN().equals(certSubject)){
                    chainList.addFirst(cert);
                    certSubject = cert.getSubjectDN();
                    certs.remove(cert);
                    continue;
                }

                if(cert.getSubjectDN().equals(certIssuer)){
                    chainList.addLast(cert);
                    certIssuer = cert.getIssuerDN();
                    certs.remove(cert);
                    continue;
                }
            }
        }
    standardTrustManager.checkServerTrusted(chainList.toArray(new X509Certificate[]{}),authType);

    }
}
  }
}

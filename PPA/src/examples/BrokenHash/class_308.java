package examples.AES; 
public class class_308 { 
private static PKCS10CertificationRequest generateCSRFile(KeyPair keyPair) throws IOException, OperatorCreationException {
    String principal = "CN=company1, OU=company1, O=company1, C=GB";
    AsymmetricKeyParameter privateKey = PrivateKeyFactory.createKey(keyPair.getPrivate().getEncoded());
    AlgorithmIdentifier signatureAlgorithm = new DefaultSignatureAlgorithmIdentifierFinder()
            .find("SHA1WITHRSA");
    AlgorithmIdentifier digestAlgorithm = new DefaultDigestAlgorithmIdentifierFinder().find("SHA-1");
    ContentSigner signer = new BcRSAContentSignerBuilder(signatureAlgorithm, digestAlgorithm).build(privateKey);

    PKCS10CertificationRequestBuilder csrBuilder = new JcaPKCS10CertificationRequestBuilder(new X500Name(
            principal), keyPair.getPublic());
    ExtensionsGenerator extensionsGenerator = new ExtensionsGenerator();
    extensionsGenerator.addExtension(X509Extension.basicConstraints, true, new BasicConstraints(true));
    extensionsGenerator.addExtension(X509Extension.keyUsage, true, new KeyUsage(KeyUsage.keyCertSign
            | KeyUsage.cRLSign));
    csrBuilder.addAttribute(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest, extensionsGenerator.generate());
    PKCS10CertificationRequest csr = csrBuilder.build(signer);

    return csr;
}

}
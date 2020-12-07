package examples.RSA; 
public class class_537 { 
public void storeRSAPublicKey(String alias, BigInteger modulus, BigInteger exponent) 
{
    /** Load the key to generate the certificate */
    KeyStore ks = getApplicationKeyStore();
    KeyStore.PrivateKeyEntry entry = (KeyStore.PrivateKeyEntry)ks.getEntry(MY_PRIVATE_KEY, null);
    X509Certificate issuerCert = (X509Certificate)entry.getCertificate();
    PrivateKey skey = entry.getPrivateKey();

    /** Prepare the certificate template */
    RSAKeyParameters params = new RSAKeyParameters(false, modulus, exponent);
    SubjectPublicKeyInfo pkInfo = SubjectPublicKeyInfoFactory.SubjectPublicKeyInfo(params);
    X500Name issuer = new X500Name(issuerCert.getIssuerX500Principal().getName());
    X500Name subject = new X500Name("CN=alias");
    X509v3CertificateBuilder builder = new X509v3CertificateBuilder(issuer, randomSeriaNumber(), new Date(), dateIn20years(), subject, pkInfo);

    /** Generate the certificate */
    JcaContentSignerBuilder csBuilder = new JcaContentSignerBuilder("SHA256withRSA");
    ContentSigner signer = csBuilder.build(skey);
    X509CertificateHolder holder = builder.build(signer);

    /** Store the certificate in the KeyStore */
    JcaX509CertificateConverter conv = new JcaX509CertificateConverter();
    X509Certificate cert = conv.getCertificate(holder);
    ks.setCertificateEntry(alias, cert);
    pushKeyStoreToPersistentStorage(ks);

}
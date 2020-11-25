package examples.AllCodeSnippets; 
public class class_1229{ 
 public static void main() { 
 136         // Clean up the certificates chain and build a new one.
 137         // Theoretically, we shouldn't have to do this, but various web servers
 138         // in practice are mis-configured to have out-of-order certificates or
 139         // expired self-issued root certificate.
 140         int chainLength = serverCertificates.length;
 141         if (serverCertificates.length > 1) {
 142           // 1. we clean the received certificates chain.
 143           // We start from the end-entity certificate, tracing down by matching
 144           // the "issuer" field and "subject" field until we can't continue.
 145           // This helps when the certificates are out of order or
 146           // some certificates are not related to the site.
 147           int currIndex;
 148           for (currIndex = 0; currIndex < serverCertificates.length; ++currIndex) {
 149             boolean foundNext = false;
 150             for (int nextIndex = currIndex + 1;
 151                  nextIndex < serverCertificates.length;
 152                  ++nextIndex) {
 153               if (serverCertificates[currIndex].getIssuerDN().equals(
 154                   serverCertificates[nextIndex].getSubjectDN())) {
 155                 foundNext = true;
 156                 // Exchange certificates so that 0 through currIndex + 1 are in proper order
 157                 if (nextIndex != currIndex + 1) {
 158                   X509Certificate tempCertificate = serverCertificates[nextIndex];
 159                   serverCertificates[nextIndex] = serverCertificates[currIndex + 1];
 160                   serverCertificates[currIndex + 1] = tempCertificate;
 161                 }
 162                 break;
 163               }
 164             }
 165             if (!foundNext) break;
 166           }
 167 
 168           // 2. we exam if the last traced certificate is self issued and it is expired.
 169           // If so, we drop it and pass the rest to checkServerTrusted(), hoping we might
 170           // have a similar but unexpired trusted root.
 171           chainLength = currIndex + 1;
 172           X509Certificate lastCertificate = serverCertificates[chainLength - 1];
 173           Date now = new Date();
 174           if (lastCertificate.getSubjectDN().equals(lastCertificate.getIssuerDN())
 175               && now.after(lastCertificate.getNotAfter())) {
 176             --chainLength;
 177           }
 178         }
  }
}

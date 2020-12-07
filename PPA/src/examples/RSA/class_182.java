package examples.RSA; 
</p>

<pre><code>/**
 * <p>Title: RSA Security</p>
 * Description: This class class_182 a RSA private and public key, reinstantiates
 * the keys from the corresponding key files.It also generates compatible .Net Public Key,
 * which we will read later in C# program using .Net Securtiy Framework
 * The reinstantiated keys are used to sign and verify the given data.</p>
 *
 * @author Shaheryar
 * @version 1.0
 */

import java.security.*;
import java.security.spec.*;
import java.io.*;
import java.security.interfaces.*;
import java.security.cert.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class class_182 {

  private KeyPairGenerator keyGen; //Key pair generator for RSA
  private PrivateKey privateKey; // Private Key Class
  private PublicKey publicKey; // Public Key Class
  private KeyPair keypair; // KeyPair Class
  private Signature sign; // Signature, used to sign the data
  private String PRIVATE_KEY_FILE; // Private key file.
  private String PUBLIC_KEY_FILE; // Public key file.
  private String DOT_NET_PUBLIC_KEY_FILE; // File to store .Net Compatible Key Data

  /**
   * Default Constructor. Instantiates the key paths and signature algorithm.
 * @throws IOException 
 * @throws InvalidKeySpecException 
 * @throws NoSuchAlgorithmException 
   */
  public SecurityManager() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {

  }


  public static void main(String args[]) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException{
      GenerateDotNetKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp6340BNzismmb/n98sTcYfNEmmzNGumdWnK1e7NNWntM6mjZMnQaVZ9HiJKmMgtn69dAU4gaMVUWACDsuup1GBxN8dLgDbtR26M0u1jf1G8AQehcKfqxqSYzxKquXXotffdYsJPpjseZbi96Y7j47kz9CjNP3y1BzjJNTWQUx9fc9e2Bpsi0GtqJ8porPBuIGTjcCnlKM14tIv6YlHtECW1L1wcOBkoj/5liI1nhlYDth/DNXg1OY11JqIIP1fO2vQPtKEpdtcTBTjmB9M45O1N8K/shTcMntFjwVTpL0hRd+eaN1bUjpMvrhFik0VcF/ZNN6Hn0Coqe+ey18dLosQIDAQAB");
  }
  public static void GenerateDotNetKey(String base64PubKey)
          throws IOException, NoSuchAlgorithmException,
          InvalidKeySpecException {
      /*
       * String base64PubKey - 
       * Is a Key retrieved from Google Checkout Merchant Account
       */
      BASE64Decoder decoder = new BASE64Decoder();

      byte[] publicKeyBytes = decoder.decodeBuffer(base64PubKey);

      EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
      RSAPublicKey publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(publicKeySpec);

      byte[] modulusBytes = publicKey.getModulus().toByteArray();
      byte[] exponentBytes = publicKey.getPublicExponent().toByteArray();

      modulusBytes = stripLeadingZeros1(modulusBytes);

      BASE64Encoder encoder = new BASE64Encoder();
      String modulusB64 = encoder.encode(modulusBytes);
      String exponentB64 = encoder.encode(exponentBytes);
int i=0;
     // return new DotNetRSA(modulusB64, exponentB64);
  }

    private static byte[] stripLeadingZeros1(byte[] a) {
      int lastZero = -1;
      for (int i = 0; i < a.length; i++) {
        if (a[i] == 0) {
          lastZero = i;
        }
        else {
          break;
        }
      }
      lastZero++;
      byte[] result = new byte[a.length - lastZero];
      System.arraycopy(a, lastZero, result, 0, result.length);
      return result;
    }


  }

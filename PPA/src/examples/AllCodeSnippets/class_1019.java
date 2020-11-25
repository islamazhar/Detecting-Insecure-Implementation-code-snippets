package examples.AllCodeSnippets; 
public class class_1019{ 
 public static void main() { 
      String hexPubKeyXY = "01f82bfb2f0a3e988adc3d053d8e6ff878154306e402d871b7d6000823a1397f";
      String hexX = hexPubKeyXY.substring(0, 32);
      String hexY = hexPubKeyXY.substring(32);
      ECPoint point = new ECPoint(new BigInteger(hexX, 16), new BigInteger(hexY, 16));

      AlgorithmParameters parameters = AlgorithmParameters.getInstance("EC", "SunEC");
      parameters.init(new ECGenParameterSpec("secp128r1"));
      ECParameterSpec ecParameters = parameters.getParameterSpec(ECParameterSpec.class);

      ECPublicKeySpec pubKeySpec = new ECPublicKeySpec(point, ecParameters);

      PublicKey key = KeyFactory.getInstance("EC", "SunEC").generatePublic(pubKeySpec);
  }
}

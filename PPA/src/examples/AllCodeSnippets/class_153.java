package examples.AllCodeSnippets; 
public class class_153{ 
 public static void main() { 
        CipherParameters p = new KeyParameter(key.getBytes("UTF-8"));

        WhirlpoolDigest w = new WhirlpoolDigest();
        HMac hm = new HMac(w);
        hm.init(p);
        hm.update(inbytes, 0, inbytes.length);
        byte[] result = new byte[hm.getMacSize()];
        hm.doFinal(result, 0);
  }
}

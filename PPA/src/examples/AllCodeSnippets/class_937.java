package examples.AllCodeSnippets; 
public class class_937{ 
 public static void main() { 
public boolean Verify(RSAPublicKey key, String signature, String data)
{
    try
    {
        Signature sign = Signature.getInstance("SHA1withRSA");
        sign.initVerify(key);
        sign.update(data.getBytes("UTF-8"));
        return sign.verify(Base64.decode(signature.getBytes("UTF-8"), Base64.NO_WRAP));
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    return false;
}
  }
}
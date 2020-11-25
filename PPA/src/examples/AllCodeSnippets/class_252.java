package examples.AllCodeSnippets; 
public class class_252{ 
 public static void main() { 
enter code here
public static void GenerateKeyPair()
{       
    try{
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.genKeyPair();

        KeyFactory fact = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec pub = fact.getKeySpec(kp.getPublic(),
          RSAPublicKeySpec.class);
        RSAPrivateKeySpec priv = fact.getKeySpec(kp.getPrivate(),
          RSAPrivateKeySpec.class);

        saveToFile("public.key", pub.getModulus(),
                  pub.getPublicExponent());
        saveToFile("private.key", priv.getModulus(),
                  priv.getPrivateExponent());
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
}

public static void saveToFile(String fileName,
  BigInteger mod, BigInteger exp) throws Exception {
  ObjectOutputStream oout = new ObjectOutputStream(
    new BufferedOutputStream(new FileOutputStream(fileName)));
  try {
    oout.writeObject(mod);
    oout.writeObject(exp);
  } catch (Exception e) {
    throw new Exception("error", e);
  } finally {
    oout.close();
  }
}
  }
}

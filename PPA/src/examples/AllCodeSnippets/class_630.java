package examples.AllCodeSnippets; 
public class class_630{ 
 public static void main() { 
AlgorithmParameterGenerator paramGen = AlgorithmParameterGenerator.getInstance("DH");
paramGen.init(1024, new SecureRandom());
AlgorithmParameters params = paramGen.generateParameters();
DHParameterSpec dhSpec = (DHParameterSpec)params.getParameterSpec(DHParameterSpec.class);
System.out.println("p: " + dhSpec.getP() + "\ng: " + dhSpec.getG() + " \nl: " + dhSpec.getL());
  }
}

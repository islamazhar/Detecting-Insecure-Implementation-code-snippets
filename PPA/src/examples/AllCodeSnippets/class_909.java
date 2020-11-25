package examples.AllCodeSnippets; 
public class class_909{ 
 public static void main() { 
Provider[] providers = Security.getProviders();
for (Provider p : providers) {
  String providerStr = String.format("%s/%s/%f\n", p.getName(),
                    p.getInfo(), p.getVersion());
  Set<Service> services = p.getServices();
  for (Service s : services) {
    if ("MessageDigest".equals(s.getType())) {
       System.out.printf("\t%s/%s/%s", s.getType(),
                            s.getAlgorithm(), s.getClassName());
    }
  }
}
  }
}

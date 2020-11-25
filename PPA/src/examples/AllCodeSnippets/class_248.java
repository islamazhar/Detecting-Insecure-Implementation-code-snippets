package examples.AllCodeSnippets; 
public class class_248{ 
 public static void main() { 
    Provider[] providers = Security.getProviders();
    for (Provider p : providers) {
        Log.d(TAG, "provider: " + p.getName());
        Set<Provider.Service> services = p.getServices();
        for (Provider.Service s : services) {
            Log.d(TAG, "--> algorithm: " + s.getAlgorithm());
        }
    }
  }
}

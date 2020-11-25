package examples.AllCodeSnippets; 
    public class class_78 {

    static {
        Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
    }

    public void printProviders() {
        for (Provider provider : Security.getProviders()) {
            System.out.println("Provider: " + provider.getName());
            for (Provider.Service service : provider.getServices()) {
                System.out.println("  Algorithm: " + service.getAlgorithm());
            }
        }
    }
}

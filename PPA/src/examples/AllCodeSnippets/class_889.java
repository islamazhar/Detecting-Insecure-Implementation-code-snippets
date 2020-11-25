package examples.AllCodeSnippets; 
public class class_889{ 
 public static void main() { 
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    if (Build.VERSION.RELEASE.equals("5.0"))
    {
        Security.removeProvider("SC");
    }
    return super.onCreateView(inflater, container, savedInstanceState);
}

@Override
public void onDestroyView() {
    if (Build.VERSION.RELEASE.equals("5.0"))
    {
        Security.addProvider(new org.spongycastle.jce.provider.BouncyCastleProvider());
    }
    super.onDestroyView();
}
  }
}

package examples.AllCodeSnippets; 
public class class_1064 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try

        {

//             PackageInfo info = getPackageManager().getPackageInfo("Your package name here",PackageManager.GET_SIGNATURE);

            for (Signature signature : info.signatures)
            {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } 
        catch (NameNotFoundException e)
        {
            System.out.println("name not found...."+e);
        } catch (NoSuchAlgorithmException e) 
        {
            System.out.println("NoSuchAlgorithmException...."+e);
        }
    }
}

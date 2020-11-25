package examples.AllCodeSnippets; 
public class class_204 extends Application {

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Application#onCreate()
     */
    @Override
    public void onCreate() {
        super.onCreate();

        // initImageLoader(getApplicationContext());

        PreferenceHelper.getPrefernceHelperInstace().init(
                getApplicationContext());

        // The following line triggers the initialization of ACRA
        if (PreferenceHelper.getPrefernceHelperInstace().getBoolean(
                PreferenceHelper.SUBMIT_LOGS, true)) {
            ACRA.init(this);
        }


            //----------It is your Key Hash-----------
        Toast.makeText(getApplicationContext(),
                "keyHash" + printKeyHash(getApplicationContext()), 1000).show();

    }

    public static String printKeyHash(Context context) {
        PackageInfo packageInfo;
        String key = null;
        try {
//             // getting application package name, as defined in manifest
            String packageName = context.getApplicationContext()
                    .getPackageName();

//             // Retriving package info
            packageInfo = context.getPackageManager().getPackageInfo(
                    packageName, PackageManager.GET_SIGNATURES);

            Log.e("Package Name=", context.getApplicationContext()
                    .getPackageName());

            for (Signature signature : packageInfo.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                key = new String(Base64.encode(md.digest(), 0));

                // String key = new String(Base64.encodeBytes(md.digest()));
                Log.e("Key Hash=", key);
            }
        } catch (NameNotFoundException e1) {
            Log.e("Name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("No such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }

        return key;
    }

}

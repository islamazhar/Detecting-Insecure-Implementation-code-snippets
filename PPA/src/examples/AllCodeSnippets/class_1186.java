package examples.AllCodeSnippets; 
public class class_1186{ 
 public static void main() { 
    /**
     * Get the current KeyStore or if not yet created, create a new one. This
     * will <b>NOT</b> load the KeyStore file identified by
     * {@link #KEYSTORE_NAME}. To load the KeyStore file, use the function
     * {@link #loadKeyStore()} which will automatically call this function (so
     * you don't need to).
     * <p>
     * 
     * @return a {@link KeyStore}
     */
    public KeyStore getKeyStore() {

        if (mKeyStore != null)
            return mKeyStore;

        try {
            String defaultType = KeyStore.getDefaultType();
            mKeyStore = KeyStore.getInstance(defaultType);
            mKeyStore.load(null, null);
        } catch (Exception e) {
            Log.w(TAG, e.getMessage());
        }

        return mKeyStore;
    }
  }
}

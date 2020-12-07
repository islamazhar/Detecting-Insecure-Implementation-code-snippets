package examples.BrokenHash; 
/**
 * Warning, this gives a false sense of security.  If an attacker has enough access to
 * acquire your password store, then he almost certainly has enough access to acquire your
 * source binary and figure out your encryption key.  However, it will prevent casual
 * investigators from acquiring passwords, and thereby may prevent undesired negative
 * publicity.
 */
public class class_843 implements SharedPreferences {
    protected static final String UTF8 = "utf-8";
    private static final char[] SEKRIT = ... ; // INSERT A RANDOM PASSWORD HERE.
                                               // Don't use anything you wouldn't want to
                                               // get out there if someone decompiled
                                               // your app.


    protected SharedPreferences delegate;
    protected Context context;

    public ObscuredSharedPreferences(Context context, SharedPreferences delegate) {
        this.delegate = delegate;
        this.context = context;
    }

    public class class_843 implements SharedPreferences.Editor {
        protected SharedPreferences.Editor delegate;

        public Editor() {
            this.delegate = ObscuredSharedPreferences.this.delegate.edit();                    
        }

        
        public Editor putBoolean(String key, boolean value) {
            delegate.putString(key, encrypt(Boolean.toString(value)));
            return this;
        }

        
        public Editor putFloat(String key, float value) {
            delegate.putString(key, encrypt(Float.toString(value)));
            return this;
        }

        
        public Editor putInt(String key, int value) {
            delegate.putString(key, encrypt(Integer.toString(value)));
            return this;
        }

        
        public Editor putLong(String key, long value) {
            delegate.putString(key, encrypt(Long.toString(value)));
            return this;
        }

        
        public Editor putString(String key, String value) {
            delegate.putString(key, encrypt(value));
            return this;
        }

        
        public void apply() {
            delegate.apply();
        }

        
        public Editor clear() {
            delegate.clear();
            return this;
        }

        
        public boolean commit() {
            return delegate.commit();
        }

        
        public Editor remove(String s) {
            delegate.remove(s);
            return this;
        }
    }

    public Editor edit() {
        return new Editor();
    }


    
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException(); // left as an exercise to the reader
    }

    
    public boolean getBoolean(String key, boolean defValue) {
        final String v = delegate.getString(key, null);
        return v!=null ? Boolean.parseBoolean(decrypt(v)) : defValue;
    }

    
    public float getFloat(String key, float defValue) {
        final String v = delegate.getString(key, null);
        return v!=null ? Float.parseFloat(decrypt(v)) : defValue;
    }

    
    public int getInt(String key, int defValue) {
        final String v = delegate.getString(key, null);
        return v!=null ? Integer.parseInt(decrypt(v)) : defValue;
    }

    
    public long getLong(String key, long defValue) {
        final String v = delegate.getString(key, null);
        return v!=null ? Long.parseLong(decrypt(v)) : defValue;
    }

    
    public String getString(String key, String defValue) {
        final String v = delegate.getString(key, null);
        return v != null ? decrypt(v) : defValue;
    }

    
    public boolean contains(String s) {
        return delegate.contains(s);
    }

    
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        delegate.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        delegate.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }




    protected String encrypt( String value ) {

        try {
            final byte[] bytes = value!=null ? value.getBytes(UTF8) : new byte[0];
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(SEKRIT));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(Settings.Secure.getString(context.getContentResolver(),Settings.System.ANDROID_ID).getBytes(UTF8), 20));
            return new String(Base64.encode(pbeCipher.doFinal(bytes), Base64.NO_WRAP),UTF8);

        } catch( Exception e ) {
            throw new RuntimeException(e);
        }

    }

    protected String decrypt(String value){
        try {
            final byte[] bytes = value!=null ? Base64.decode(value,Base64.DEFAULT) : new byte[0];
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(SEKRIT));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(Settings.Secure.getString(context.getContentResolver(),Settings.System.ANDROID_ID).getBytes(UTF8), 20));
            return new String(pbeCipher.doFinal(bytes),UTF8);

        } catch( Exception e) {
            throw new RuntimeException(e);
        }
    }

}

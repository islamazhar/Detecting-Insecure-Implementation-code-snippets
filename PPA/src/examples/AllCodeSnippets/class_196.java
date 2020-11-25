package examples.AllCodeSnippets; 
public class class_196{ 
 public static void main() { 
private void genKey() {
        // TODO Auto-generated method stub
        Context context = this;
        final Dialog myDialog = new Dialog(context);

        myDialog.setContentView(R.layout.dialog);

        myDialog.setTitle("enter key");

        key_edt = (EditText) myDialog.findViewById(R.id.dg_key_tv);
        Button ok_btn = (Button) myDialog.findViewById(R.id.dg_ok_btn);
        Button cancel_btn = (Button) myDialog.findViewById(R.id.dg_cancel_btn);

        Log.d(TAG1, key_str);

        ok_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                key_str = key_edt.getText().toString();

                // only try to create the Key Spec now we have our key string
                // first check to make sure it's not blank
                if(key_str != null && !key_str.isEmpty()){
                    try {
                        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
                        sr.setSeed(key_str.getBytes());

                        KeyGenerator kg = KeyGenerator.getInstance("AES");
                        kg.init(128, sr);
                        this.sks = new SecretKeySpec((kg.generateKey()).getEncoded(), "AES");
                        Log.i("encrypt", sks.toString());

                    } catch (Exception e) {
                        Log.e(TAG, "AES secret key spec error");
                    }
                }
                else{   // string is empty
                    // make some toast to alert user
                }
            }
        });

        cancel_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                myDialog.dismiss();
            }
        });
        myDialog.show();

    }
  }
}

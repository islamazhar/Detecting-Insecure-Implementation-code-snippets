package examples.AllCodeSnippets; 
// package com.yourapp.android.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class class_1223 extends Activity {
    TextView encryptedDataView;
    EditText editInputData;
    private Context cntx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.cntx = getApplicationContext();
        Button btnEncrypt = (Button) findViewById(R.id.buttonEncrypt);
        Button btnDecrypt = (Button) findViewById(R.id.buttonDecrypt);
        Button btnDelete = (Button) findViewById(R.id.buttonDelete);
        editInputData = (EditText)findViewById(R.id.editInputData) ;
        encryptedDataView = (TextView) findViewById(R.id.encryptView);

        /**********************************************/
            /** INITIALIZE KEY AND INITIALIZATION VECTOR **/
        String key = "12345678909876543212345678909876";
        String iv = "1234567890987654";
        KeyManager km = new KeyManager(getApplicationContext());
        km.setIv(iv.getBytes());
        km.setId(key.getBytes());
        /**********************************************/

        btnEncrypt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String Data = editInputData.getText().toString();
                String Encrypted_Data = "data";
                try {
                    Crypto crypto = new Crypto(cntx);
                    Encrypted_Data = crypto.armorEncrypt(Data.getBytes());
                }   catch (InvalidKeyException e) {
                    Log.e("SE3", "Exception in StoreData: " + e.getMessage());
                    } catch (NoSuchAlgorithmException e) {
                    Log.e("SE3", "Exception in StoreData: " + e.getMessage());
                    } catch (NoSuchPaddingException e) {
                    Log.e("SE3", "Exception in StoreData: " + e.getMessage());
                    } catch (IllegalBlockSizeException e) {
                    Log.e("SE3", "Exception in StoreData: " + e.getMessage());
                    } catch (BadPaddingException e) {
                    Log.e("SE3", "Exception in StoreData: " + e.getMessage());
                    } catch (InvalidAlgorithmParameterException e) {
                    Log.e("SE3", "Exception in StoreData: " + e.getMessage());
                    }
                encryptedDataView.setText(Encrypted_Data);
            }
        });

        btnDecrypt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String Data = encryptedDataView.getText().toString();
                String Decrypted_Data = "data";
                try {
                    Crypto crypto = new Crypto(cntx);
                    Decrypted_Data = crypto.armorDecrypt(Data);
                }   catch (InvalidKeyException e) {
                    Log.e("SE3", "Exception in StoreData: " + e.getMessage());
                    } catch (NoSuchAlgorithmException e) {
                    Log.e("SE3", "Exception in StoreData: " + e.getMessage());
                    } catch (NoSuchPaddingException e) {
                    Log.e("SE3", "Exception in StoreData: " + e.getMessage());
                    } catch (IllegalBlockSizeException e) {
                    Log.e("SE3", "Exception in StoreData: " + e.getMessage());
                    } catch (BadPaddingException e) {
                    Log.e("SE3", "Exception in StoreData: " + e.getMessage());
                    } catch (InvalidAlgorithmParameterException e) {
                    Log.e("SE3", "Exception in StoreData: " + e.getMessage());
                    }
                encryptedDataView.setText(Decrypted_Data);
            }
        });

        btnDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                encryptedDataView.setText(" Deleted ");
            }
        });

    }

}

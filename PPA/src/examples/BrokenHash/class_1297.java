package examples.AES; 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.facebook.widget.LoginButton.UserInfoChangedCallback;


public class class_1297 extends ActionBarActivity{

     private LoginButton loginBtn;
     private Button updateStatusBtn;
  
     private TextView fbquote;
     
     private TextView userName;
  
     private UiLifecycleHelper uiHelper;
  
     private static final List<String> PERMISSIONS = Arrays.asList("publish_actions");
     
     private String message;
     
     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         
      // Add code to print out the key hash
         try {
             PackageInfo info = getPackageManager().getPackageInfo(
                     "com.facebook.samples.hellofacebook", 
                     PackageManager.GET_SIGNATURES);
             for (Signature signature : info.signatures) {
                 MessageDigest md = MessageDigest.getInstance("SHA");
                 md.update(signature.toByteArray());
                 Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
                 }
         } catch (NameNotFoundException e) {

         } catch (NoSuchAlgorithmException e) {

         }

         
         Intent intent = getIntent();
      
      message = intent.getStringExtra("quote");     
    
  
         uiHelper = new UiLifecycleHelper(this, statusCallback);
         uiHelper.onCreate(savedInstanceState);
  
         setContentView(R.layout.sharehelper_activity);
     
         fbquote = (TextView)findViewById(R.id.FbTextView);
         fbquote.setText(message);
         
         userName = (TextView) findViewById(R.id.user_name);
         loginBtn = (LoginButton) findViewById(R.id.fb_login_button);
         loginBtn.setUserInfoChangedCallback(new UserInfoChangedCallback() {
             
             public void onUserInfoFetched(GraphUser user) {
                 if (user != null) {
                     userName.setText("Hello, " + user.getName());
                 } else {
                     userName.setText("You are not logged");
                 }
             }
         });
  
         updateStatusBtn = (Button) findViewById(R.id.update_status);
         updateStatusBtn.setOnClickListener(new OnClickListener() {
  
             
             public void onClick(View v) {
              postStatusMessage();
             }
         });
  
         buttonsEnabled(false);
     }
  
     private Session.StatusCallback statusCallback = new Session.StatusCallback() {
         
         public void call(Session session, SessionState state,
                 Exception exception) {
             if (state.isOpened()) {
                 buttonsEnabled(true);
                 Log.d("FacebookSampleActivity", "Facebook session opened");
             } else if (state.isClosed()) {
                 buttonsEnabled(false);
                 Log.d("FacebookSampleActivity", "Facebook session closed");
             }
         }
     };
  
     public void buttonsEnabled(boolean isEnabled) {
         updateStatusBtn.setEnabled(isEnabled);
     }
  
    
     public void postStatusMessage() {
         if (checkPermissions()) {
             Request request = Request.newStatusUpdateRequest(
                     Session.getActiveSession(), message,
                     new Request.Callback() {
                         
                         public void onCompleted(Response response) {
                             if (response.getError() == null)
                                 Toast.makeText(ShareHelper.this,
                                         "Quote Shared successfully",
                                         Toast.LENGTH_LONG).show();
                         }
                     });
             request.executeAsync();
         } else {
             requestPermissions();
         }
     }
  
     public boolean checkPermissions() {
         Session s = Session.getActiveSession();
         if (s != null) {
             return s.getPermissions().contains("publish_actions");
         } else
             return false;
     }
  
     public void requestPermissions() {
         Session s = Session.getActiveSession();
         if (s != null)
             s.requestNewPublishPermissions(new Session.NewPermissionsRequest(
                     this, PERMISSIONS));
     }
  
     
     public void onResume() {
         super.onResume();
         uiHelper.onResume();
         buttonsEnabled(Session.getActiveSession().isOpened());
     }
  
     
     public void onPause() {
         super.onPause();
         uiHelper.onPause();
     }
  
     
     public void onDestroy() {
         super.onDestroy();
         uiHelper.onDestroy();
     }
  
     
     public void onActivityResult(int requestCode, int resultCode, Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         uiHelper.onActivityResult(requestCode, resultCode, data);
     }
  
     
     public void onSaveInstanceState(Bundle savedState) {
         super.onSaveInstanceState(savedState);
         uiHelper.onSaveInstanceState(savedState);
     }
}",3,0,dcd35cf8ddea16ac6429bc43ea8e8a1c91a154b04677c76fadc5ff9985990059
String encryptKey(String input)
{
    byte[] inBytes=input.getBytes();
    String finalString=null;
    try {
        Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] keyBytes=md.digest((KeyPart1+KeyPart2).getBytes());
        keyBytes = Arrays.copyOf(keyBytes, 16);
        SecretKey key= new SecretKeySpec(keyBytes,"AES");
        IvParameterSpec ivSpec = new IvParameterSpec(new byte[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        cipher.init(Cipher.ENCRYPT_MODE,key,ivSpec);
        byte[] outBytes = new byte[cipher.getOutputSize(inBytes.length)];
        //cipher.update(encrypted, 0, encrypted.length, decrypted, 0);
        outBytes=cipher.doFinal(inBytes);
        finalString=new String(Base64.encode(outBytes,0));
        Log.v(TAG,"Encrypted="+finalString);

    } catch (NoSuchAlgorithmException e) {
        Log.e(TAG,"No Such Algorithm",e);
    } catch (NoSuchPaddingException e) {
        Log.e(TAG,"No Such Padding",e);
    } catch (InvalidKeyException e) {
        Log.e(TAG,"Invalid Key",e);
    } catch (InvalidAlgorithmParameterException e) {
        Log.e(TAG,"Invalid Algorithm Parameter",e);
    } catch (IllegalBlockSizeException e) {
    } catch (BadPaddingException e) {}
    return finalString;
}

String decryptKey(String base64Text)
{
    byte[] encrypted=Base64.decode(base64Text,0);
    //encrypted=base64Text.getBytes();
    String decryptedString=null;
    try {
        Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] keyBytes=md.digest((KeyPart1+KeyPart2).getBytes());
        keyBytes = Arrays.copyOf(keyBytes, 16);
        SecretKey key= new SecretKeySpec(keyBytes,"AES");
        IvParameterSpec ivSpec = new IvParameterSpec(new byte[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        cipher.init(Cipher.DECRYPT_MODE,key,ivSpec);
        byte[] decrypted = new byte[cipher.getOutputSize(encrypted.length)];
        //cipher.update(encrypted, 0, encrypted.length, decrypted, 0);
        decrypted=cipher.doFinal(encrypted);
        decryptedString=new String(decrypted);
    } catch (NoSuchAlgorithmException e) {
        logStackTrace(e);
    } catch (NoSuchPaddingException e) {
        logStackTrace(e);
    } catch (InvalidKeyException e) {
        logStackTrace(e);
    } catch (InvalidAlgorithmParameterException e) {
        logStackTrace(e);
    } catch (IllegalBlockSizeException e) {
        logStackTrace(e);
    } catch (BadPaddingException e) {
        logStackTrace(e);
    }
    return decryptedString;
}

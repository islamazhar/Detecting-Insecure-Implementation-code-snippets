package examples.AllCodeSnippets; 
public class class_58{ 
 public static void main() { 
public BoolString tryEncrypt(String inString, String password) {
    try {
        String value= encrypt(inString, password);
        return new BoolString(true,",value);
    }
    catch (GeneralSecurityException e){
        return new BoolString(false,e.getMessage(),");
    }
}

    protected void onPostExecute(BoolString result){          
        progress.dismiss();
        if (result.success){
                result.value;
        }
        else {
              result.err;
        }
    }
  }
}

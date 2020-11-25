package examples.AllCodeSnippets; 
public class class_1332{ 
 public static void main() { 
private class DownloadImageTask extends AsyncTask<String, String, Void> {
    int flag=0;
    protected Void doInBackground(String... arg0) {
        try{
            m = new Mail(emailaddress, password);
            m.setFrom(emailaddress.trim());
            toArr =   email.split(",");
            for(int i=0;i<toArr.length;i++)
            {
                                    // checking all emails entered are correct or not
                if (toArr[i].trim().matches(EMAIL_PATTERN))
                {
                    emailflag = true;
                }
                else
                {
                    emailflag = false;
                    break;
                }
            }
            m.setTo(toArr);
            if(!Subject.equals("))
            {
                m.setSubject(txtSubject.getText().toString());
            }
            else   
            {
                m.setSubject("No Subject");
            }
            if(!EmailBody.equals("))
            {
                m.setBody(txtEmailBody.getText().toString());
            }
            else  
            {
                m.setBody("No Message");                    
            }
            if(!attachefile.equals("))
            {
                String[] temp;
                temp = attachefile.split("\\*");
                if(temp.length>0)
                {
                    for(int i =0; i < temp.length ; i++)
                    {   
                        m.addAttachment(temp[i]);
                    }
                }
            }
            if(emailflag && m.send())
            {
                flag=1;
                Intent intent = new Intent(SendEmail.this,SendEmail.class);
                startActivity(intent);
            }
            else
            {
                flag = 0;
            }

        }catch(Exception e){

                e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void result) 
    {
        progressDialog.dismiss();
        if(flag==1)
        {
            Toast.makeText(SendEmail.this, "Sent Successfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(SendEmail.this, "Failed please give correct email address", Toast.LENGTH_SHORT).show();
        }
    }
}
  }
}

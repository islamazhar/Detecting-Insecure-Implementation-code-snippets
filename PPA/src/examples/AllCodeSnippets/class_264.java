package examples.AllCodeSnippets; 
public class class_264{ 
 public static void main() { 
public boolean deleteFile(File target)
{
    if (System.getSecurityManager() != null)
    {
        try
        {
            Actions actions = (Actions) m_actions.get();
            actions.set(Actions.DELETE_FILE_ACTION, target);
            return ((Boolean) AccessController.doPrivileged(actions, m_acc))
                .booleanValue();
        }
        catch (PrivilegedActionException ex)
        {
            throw (RuntimeException) ex.getException();
        }
    }
    else
    {
        // Solution: Rename before deleting
        // http://stackoverflow.com/questions/11539657/open-failed-ebusy-device-or-resource-busy

        File to = new File(target.getAbsolutePath() + System.currentTimeMillis());
        boolean renameStatus = target.renameTo(to);
        boolean deleteStatus = to.delete();
        boolean returnStatus = ( renameStatus && deleteStatus );

        // Debug SecureAction
        //boolean returnStatus = target.delete();
        Log.e ( "SecureAction" , "Deleting " + target + " delete(): " + returnStatus );
        return returnStatus;
    }
}
  }
}

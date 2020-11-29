package examples.AES; 
public class class_6 { 
import java.security.SecureRandom;
class secure{
    public static void main(String[] args) throws Exception{
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        System.out.println(random.nextInt(100));
    }
}

}
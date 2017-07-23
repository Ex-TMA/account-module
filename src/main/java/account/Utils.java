package account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by truongnguyen on 7/23/17.
 */
public class Utils {

    private static PasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encode(String rawPass){
        return encoder.encode(rawPass);
    }
    public static boolean match(String rawPass, String encodedPass){
        return encoder.matches(rawPass, encodedPass);
    }

}

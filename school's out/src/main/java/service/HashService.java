package service;

import java.io.UnsupportedEncodingException;
import org.mindrot.jbcrypt.BCrypt;


public class HashService {
    public static String createSalt() throws UnsupportedEncodingException {return BCrypt.gensalt();
    }

    public static String hashPassword(String password, String salt){return BCrypt.hashpw(password,salt);
    }
}

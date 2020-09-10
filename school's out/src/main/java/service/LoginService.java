package service;

import model.Login;
import model.User;
import org.mindrot.jbcrypt.BCrypt;
import repository.LoginRep;
import java.io.UnsupportedEncodingException;

public class LoginService {

    public static Boolean login(String loginName, String password){
        Login loginAccount = LoginRep.getLoginAccount(loginName);

        if(verifyLogin(loginName) && BCrypt.checkpw(password, loginAccount.getPasswordHash())){
            return true;
        }
        else return false;
    }

    public static boolean verifyLogin(String login){
        return LoginRep.verifyLoginExists(login);
    }

    public static User getUserFromLoging(String login){
        return LoginRep.getUserFromLogin(login);
    }

    public static void createLogin(String LoginName, String password, User user) throws UnsupportedEncodingException {
        Login login = new Login();
        login.setLogin(LoginName);
        login.setSalt(HashService.createSalt());
        login.setActive(false);
        login.setPasswordHash(HashService.hashPassword(password , login.getSalt()));
        login.setUser(user);
        LoginRep.createLogin(login);
    }
}

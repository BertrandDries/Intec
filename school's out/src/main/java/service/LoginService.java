package service;

import model.Login;
import org.mindrot.jbcrypt.BCrypt;
import repository.LoginRepository;
import java.io.UnsupportedEncodingException;

public class LoginService {

    public static Boolean login(String loginName, String password){
        Login loginAccount = LoginRepository.getLoginAccount(loginName);

        if(LoginRepository.verifyLoginExists(loginName) && BCrypt.checkpw(password, loginAccount.getPasswordHash())){
            return true;
        }
        else return false;
    }

    public static void validateLogin(String login){
        LoginRepository.validateLogin(login);
    }

    public static void createLogin(String LoginName, String password) throws UnsupportedEncodingException {
        Login login = new Login();
        login.setLogin(LoginName);
        login.setSalt(HashService.createSalt());
        login.setActive(false);
        login.setPasswordHash(HashService.hashPassword(password , login.getSalt()));
        LoginRepository.createLogin(login);
    }


}

package service;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

public class CreateAccountService {
    private static void createSalt() throws UnsupportedEncodingException {
        SecureRandom random = new SecureRandom();
        byte[] secureRandom =new byte[10];
        random.nextBytes(secureRandom);
        for(byte bit : secureRandom){
            System.out.println(bit);
        }
        String value = new String(secureRandom, "ASCII");
        System.out.println(value);
    }
}

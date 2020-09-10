package service;

import model.UserType;
import repository.UserTypeRep;

public class UserTypeService {
    public static UserType getUserType(String name){
       return UserTypeRep.getUserType(name);
    }
}

package service;

import model.User;
import model.UserType;
import repository.UserRep;

public class UserService {
    public static User getUser(int id ){
       return UserRep.getUser(id);
    }

    public static String getUserType(int id){
        return getUser(id).getUserType().getUserType();
    }

    public static User createUser(String name, String familyName, String userType){
       User user = new User();
       user.setName(name);
       user.setFamilyName(familyName);
       user.setValidated(false);
       user.setUserType(UserTypeService.getUserType(userType));
       UserRep.createUser(user);
       return user;
    }
}

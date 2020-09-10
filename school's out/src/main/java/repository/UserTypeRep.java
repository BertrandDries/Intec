package repository;

import model.UserType;

import javax.persistence.EntityManager;

public class UserTypeRep {

    public static UserType getUserType(String name){
        return QueryService.getUserType(name);
    }
}

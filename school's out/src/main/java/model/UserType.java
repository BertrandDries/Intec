package model;

import javax.persistence.*;

@Entity
public class UserType {
    @Id
    @GeneratedValue
    private int userTypeID;

    private String userType;

    public String getUserType() {
        return userType;
    }

    public UserType setUserType(String userType) {
        this.userType = userType;
        return this;
    }
}

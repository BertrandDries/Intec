package model;

import javax.persistence.*;

@Entity
public class UserType {
    @Id
    @GeneratedValue
    int userTypeID;

    String userType;
}

package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    int userID;

    String name;
    String familyName;

    @ManyToMany
    List<Course> activeCourses;
    @ManyToMany
    List<Course> fnishedCourses;

    @ManyToOne
    UserType userType;



}

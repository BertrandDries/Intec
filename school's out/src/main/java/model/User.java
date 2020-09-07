package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int userID;

    private String name;
    private String familyName;

    @ManyToMany
    private List<Course> activeCourses;
    @ManyToMany
    private List<Course> fnishedCourses;

    @ManyToOne
    private UserType userType;

    public int getUserID() {
        return userID;
    }

    public User setUserID(int userID) {
        this.userID = userID;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public User setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public List<Course> getActiveCourses() {
        return activeCourses;
    }

    public User setActiveCourses(List<Course> activeCourses) {
        this.activeCourses = activeCourses;
        return this;
    }

    public List<Course> getFnishedCourses() {
        return fnishedCourses;
    }

    public User setFnishedCourses(List<Course> fnishedCourses) {
        this.fnishedCourses = fnishedCourses;
        return this;
    }

    public UserType getUserType() {
        return userType;
    }

    public User setUserType(UserType userType) {
        this.userType = userType;
        return this;
    }
}

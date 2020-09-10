package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private int courseID;
    private String courseName;
    private String description;
    private Boolean active;
    @OneToMany(mappedBy = "course")
    private List<Module> modules;

    private String courseImageURL;

    public int getCourseID() {
        return courseID;
    }

    public Course setCourseID(int courseID) {
        this.courseID = courseID;
        return this;
    }

    public String getCourseName() {
        return courseName;
    }

    public Course setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public Course setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public List<Module> getModules() {
        return modules;
    }

    public Course setModules(List<Module> modules) {
        this.modules = modules;
        return this;
    }

    public String getCourseImageURL() {
        return courseImageURL;
    }

    public Course setCourseImageURL(String courseImageURL) {
        this.courseImageURL = courseImageURL;
        return this;
    }

    @Override
    public String toString() {
        return  courseID +
                "   Course{" +
                "courseName='" + courseName + '\'' +
                ", description='" + description + '\''+
                '}';
    }
}
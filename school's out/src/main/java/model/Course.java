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

}

package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Module {
    @Id
    @GeneratedValue
    private int moduleID;
    private String moduleName;
    private String moduleDescription;

    @ManyToOne
    private Course course;

    //private List<Exam> exams;
}

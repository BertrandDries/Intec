package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Exam {
    @Id
    @GeneratedValue
    private int examID;

    private String examName;

    private String examDescription;

    private LocalDate date;

    private int weight;

    private int total;

    @ManyToOne
    private Module module;

    private String examPDFURL;
}

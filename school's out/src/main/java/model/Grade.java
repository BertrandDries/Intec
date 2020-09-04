package model;

import javax.persistence.*;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    private int gradeID;

    @ManyToOne
    private Exam exam;

    @ManyToOne
    private User user;

    private int scoreInPercent;
}

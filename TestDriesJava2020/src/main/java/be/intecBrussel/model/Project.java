package be.intecBrussel.model;

import java.sql.Date;

public class Project {
    int projectID;
    Date start;
    Date end;
    int price;
    String description;

    @Override
    public String toString() {
        return "Project{" +
                "projectID=" + projectID +
                ", start=" + start +
                ", end=" + end +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    public Project(int projectID, Date start, Date end, int price, String description) {
        this.projectID = projectID;
        this.start = start;
        this.end = end;
        this.price = price;
        this.description = description;
    }

    public int getProjectID() {
        return projectID;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

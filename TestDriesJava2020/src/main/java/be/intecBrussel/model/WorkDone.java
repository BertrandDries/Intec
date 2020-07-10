package be.intecBrussel.model;

import java.sql.Date;

public class WorkDone {
    private int employeeID;
    private String employeeGivenName;
    private String employeeName;
    private int projectID;
    private Date dateOfWork;
    private int hoursWorked;
    private String remarks;

    @Override
    public String toString() {
        return "WorkDone{" +
                "employeeID=" + employeeID +
                ", employeeGivenName='" + employeeGivenName + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", projectID=" + projectID +
                ", dateOfWork=" + dateOfWork +
                ", hoursWorked=" + hoursWorked +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public String toString2() {
        return "WorkDone{" +
                "employeeID=" + employeeID +
                ", employeeGivenName='" + employeeGivenName + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", projectID=" + projectID +
                ", hoursWorked=" + hoursWorked +
                '}';
    }

    public String getEmployeeGivenName() {
        return employeeGivenName;
    }

    public void setEmployeeGivenName(String employeeGivenName) {
        this.employeeGivenName = employeeGivenName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public Date getDateOfWork() {
        return dateOfWork;
    }

    public void setDateOfWork(Date dateOfWork) {
        this.dateOfWork = dateOfWork;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

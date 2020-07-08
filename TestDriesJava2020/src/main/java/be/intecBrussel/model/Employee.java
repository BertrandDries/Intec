package be.intecBrussel.model;


import java.sql.Date;

public class Employee {
    private int employeeID;
    private String givenName;
    private String name;
    private String number;
    private String ICEnumber;
    private java.sql.Date birthday;
    private int wages;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", givenName='" + givenName + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", ICEnumber=" + ICEnumber +
                ", birthday=" + birthday +
                ", wages=" + wages +
                '}';
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getICEnumber() {
        return ICEnumber;
    }

    public void setICEnumber(String ICEnumber) {
        this.ICEnumber = ICEnumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getWages() {
        return wages;
    }

    public void setWages(int wages) {
        this.wages = wages;
    }
}


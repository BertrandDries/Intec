package be.intecBrussel.services;

import be.intecBrussel.connectivity.WorkDoneDAO;
import be.intecBrussel.model.WorkDone;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class WorkDoneServices {

    public static List<WorkDone> getWorkDone() throws SQLException {
        return WorkDoneDAO.getWorkDone();
    }

    public static List<WorkDone> getWorkDoneEmployee(int employeeID) throws SQLException {
        return WorkDoneDAO.getWorkFromEmployeeID(employeeID);
    }

    public static void deleteWorkDone(int projectID,int employeeID) throws SQLException {
        WorkDoneDAO.deleteWorkDone(projectID , employeeID);
    }

    public static void addWorkDone(int employeeID, int projectID, Date date, int hours, String remarks) throws SQLException {
        WorkDone workDone = new WorkDone();
        workDone.setEmployeeID(employeeID);
        workDone.setProjectID(projectID);
        workDone.setDateOfWork(date);
        workDone.setHoursWorked(hours);
        workDone.setRemarks(remarks);
        WorkDoneDAO.addWorkDone(workDone);
    }


    public static void updateWorkDone(int employeeID, int projectID, String choice, Date value) throws SQLException {
        WorkDoneDAO.updateWorkDone(employeeID,projectID,choice,value);
    }
    public static void updateWorkDone(int employeeID, int projectID, String choice, String value) throws SQLException {
        WorkDoneDAO.updateWorkDone(employeeID,projectID,choice,value);
    }
    public static void updateWorkDone(int employeeID, int projectID, String choice, int value) throws SQLException {
        WorkDoneDAO.updateWorkDone(employeeID,projectID,choice,value);
    }

    public static List<WorkDone> getWorkDoneMax(int projectID) throws SQLException {
        return WorkDoneDAO.getWorkDoneMax(projectID);
    }
}

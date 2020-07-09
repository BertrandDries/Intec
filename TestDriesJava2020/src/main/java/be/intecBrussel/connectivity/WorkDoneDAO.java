package be.intecBrussel.connectivity;
import be.intecBrussel.model.Employee;
import be.intecBrussel.model.Project;
import be.intecBrussel.model.WorkDone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkDoneDAO {

    public static List<WorkDone> parseResult(ResultSet resultSet) throws SQLException {
        List<WorkDone> workDones = new ArrayList<>();
        while (resultSet.next()) {
            WorkDone workDone = new WorkDone();
            workDone.setEmployeeID(resultSet.getInt("EmployeeID"));
            workDone.setEmployeeGivenName(resultSet.getString("GivenName"));
            workDone.setEmployeeName(resultSet.getString("Name"));
            workDone.setProjectID(resultSet.getInt("ProjectID"));
            workDone.setDateOfWork(resultSet.getDate("DateOfWork"));
            workDone.setHoursWorked(resultSet.getInt("HoursWorked"));
            workDone.setRemarks(resultSet.getString("Remarks"));
            workDones.add(workDone);
        }
        return workDones;
    }

    public static List<WorkDone> getWorkDone() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        String sql = "SELECT WorkDone.EmployeeID, Employees.GivenName, Employees.Name, ProjectID, DateOfWork, HoursWorked, Remarks " +
                    "FROM WorkDone,Employees " +
                    "WHERE WorkDone.employeeID = Employees.EmployeeID  ";
        ResultSet resultSet = statement.executeQuery(sql);
        return parseResult(resultSet);
    }
    public static List<WorkDone> getWorkFromID(int ID) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT WorkDone.EmployeeID, Employees.GivenName, Employees.Name, ProjectID, DateOfWork, HoursWorked, Remarks " +
                "FROM WorkDone,Employees " +
                "WHERE WorkDone.EmployeeID = Employees.EmployeeID  AND WorkDone.employeeID = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,ID);
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        return parseResult(resultSet);
    }

    public static void deleteWorkDone(int projectID, int employeeID) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql =" DELETE FROM WorkDone WHERE ProjectID = ? AND EmployeeID = ?";
        PreparedStatement preparedStatement= conn.prepareStatement(sql);
        preparedStatement.setInt(1, projectID);
        preparedStatement.setInt(2, employeeID);
        preparedStatement.executeUpdate();
    }

    public static void addWorkDone(WorkDone workDone) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql =  "INSERT INTO WorkDone  VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, workDone.getEmployeeID());
        preparedStatement.setInt(2, workDone.getProjectID());
        preparedStatement.setDate(3, workDone.getDateOfWork());
        preparedStatement.setInt(4, workDone.getHoursWorked());
        preparedStatement.setString(5, workDone.getRemarks());
        preparedStatement.executeUpdate();
    }

    public static void updateWorkDone(int employeeID,int projectID, String collum, int value) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql =  " UPDATE WorkDone SET "+ collum +" = ? Where EmployeeID = ? AND ProjectID = ?; ";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,value);
        preparedStatement.setInt(2,employeeID);
        preparedStatement.setInt(3,projectID);
        preparedStatement.executeUpdate();
    }
    public static void updateWorkDone(int employeeID,int projectID, String collum, Date value) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql =  " UPDATE WorkDone SET "+ collum +" = ? Where EmployeeID = ? AND ProjectID = ?; ";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setDate(1,value);
        preparedStatement.setInt(2,employeeID);
        preparedStatement.setInt(3,projectID);
        preparedStatement.executeUpdate();
    }
    public static void updateWorkDone(int employeeID,int projectID, String collum, String value) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql =  " UPDATE WorkDone SET "+ collum +" = ? Where EmployeeID = ? AND ProjectID = ?; ";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,value);
        preparedStatement.setInt(2,employeeID);
        preparedStatement.setInt(3,projectID);
        preparedStatement.executeUpdate();
    }
}



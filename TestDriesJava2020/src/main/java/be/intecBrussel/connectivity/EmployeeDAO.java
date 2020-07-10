package be.intecBrussel.connectivity;

import be.intecBrussel.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public static List<Employee> parseResult(ResultSet resultSet) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        while (resultSet.next()){
            Employee employee = new Employee();
            employee.setEmployeeID(resultSet.getInt("EmployeeID"));
            employee.setGivenName(resultSet.getString("GivenName"));
            employee.setName(resultSet.getString("Name"));
            employee.setNumber(resultSet.getString("Number"));
            employee.setICEnumber(resultSet.getString("ICENumber"));
            employee.setBirthday(resultSet.getDate("DateOfBirth"));
            employee.setWages(resultSet.getInt("Wages"));
            employees.add(employee);
        }
        return employees;
    }

    public static List<Employee> getEmployees() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM Employees";
        ResultSet resultSet = statement.executeQuery(sql);
        return parseResult(resultSet);
    }

    public static void addEmployee(Employee employee) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql =  "INSERT INTO Employees (GivenName,Name,Number, ICENumber, DateOfBirth, Wages) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, employee.getGivenName());
        preparedStatement.setString(2, employee.getName());
        preparedStatement.setString(3, employee.getNumber());
        preparedStatement.setString(4, employee.getICEnumber());
        preparedStatement.setDate(5,  employee.getBirthday());
        preparedStatement.setInt(6, employee.getWages());

        preparedStatement.executeUpdate();
    }

    public static void updateEmployee(int employeeID, String collum, String value) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql =  " UPDATE Employees SET "+ collum +" = ? Where EmployeeID = ?; ";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,value);
        preparedStatement.setInt(2,employeeID);
        preparedStatement.executeUpdate();
    }
    public static void updateEmployee(int employeeID, String collum, int value) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql =  " UPDATE Employees SET "+ collum +" = ? Where EmployeeID = ?; ";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,value);
        preparedStatement.setInt(2,employeeID);
        preparedStatement.executeUpdate();
    }

    public static void deleteEmployee(int employeeiD) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql =" DELETE FROM Employees WHERE EmployeeID = ?";
        PreparedStatement preparedStatement= conn.prepareStatement(sql);
        preparedStatement.setInt(1, employeeiD);
        preparedStatement.executeUpdate();
    }

    public static List<Employee> searchEmployees(String name) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM Employees WHERE Name like ? OR GivenName LIKE ? ";
        PreparedStatement preparedStatement= conn.prepareStatement(sql);
        preparedStatement.setString(1, "%"+ name+ "%");
        preparedStatement.setString(2, "%"+ name+ "%");
        return parseResult(preparedStatement.executeQuery());
    }
    public static List<Employee> searchEmployeesID (int ID) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM Employees WHERE EmployeeID = ?";
        PreparedStatement preparedStatement= conn.prepareStatement(sql);
        preparedStatement.setInt(1, ID);
        return parseResult(preparedStatement.executeQuery());
    }

    public static List<Employee> getBirthdayThisWeek() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM `Employees` where DATE_FORMAT(DateOfBirth, '%m-%d') >= DATE_FORMAT(NOW(), '%m-%d') and DATE_FORMAT(DateOfBirth, '%m-%d') <= DATE_FORMAT((NOW() + INTERVAL +7 DAY), '%m-%d') ";
        PreparedStatement preparedStatement= conn.prepareStatement(sql);
        return parseResult(preparedStatement.executeQuery());
    }

    public static int getEmployeeWages(int employeeID) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM Employees where EmployeeID = ?";
        PreparedStatement preparedStatement= conn.prepareStatement(sql);
        preparedStatement.setInt(1,employeeID);
        return parseResult(preparedStatement.executeQuery()).get(0).getWages();
    }
}

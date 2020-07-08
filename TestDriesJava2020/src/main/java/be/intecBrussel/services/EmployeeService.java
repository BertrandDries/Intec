package be.intecBrussel.services;

import be.intecBrussel.connectivity.EmployeeDAO;
import be.intecBrussel.model.Employee;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    public static List<Employee> getEmployees() throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        return employeeDAO.getEmployees();

    }

    public static void addEmployee(String givenname, String name, String number, String icenumber, Date birthday, int wages) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = new Employee();
        employee.setGivenName(givenname);
        employee.setName(name);
        employee.setNumber(number);
        employee.setICEnumber(icenumber);
        employee.setBirthday(birthday);
        employee.setWages(wages);
        employeeDAO.addEmployee(employee);
    }

    public static void updateEmployee(int employeeID, String collum, String value) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.updateEmployee(employeeID,collum,value);
    }

    public static void updateEmployee(int employeeID, String collum, int value) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.updateEmployee(employeeID,collum,value);
    }

    public static void deleteEmployee(int ID) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.deleteEmployee(ID);
    }

    public static List<Employee> searchEmployees(String name) throws SQLException {
        List<Employee> employees = EmployeeDAO.searchEmployees(name);
        return employees;
    }

    public static List<Employee> getBirthdays() throws SQLException {
        List<Employee> employees = EmployeeDAO.getBirthdayThisWeek();
        return employees;
    }
}

package be.intecBrussel;
import be.intecBrussel.userInterface.*;

import java.sql.SQLException;


public class main {
    public static void main(String[] args){
        System.out.println("Welcome to the D++ database.");
        try {
            StartScreen.Start();
        } catch (SQLException e) {
            System.out.println("A problem occurred while connecting to the database. \n please check your connection and try again.");
        }
    }
}


//        EmployeeService employeeService = new EmployeeService();
//        EmployeeDAO employeeDAO = new EmployeeDAO();
//        EmployeeService.addEmployee("Olivia","Maria","0475968532","","1996-07-09", 6000);
//
//
//        List<Employee> employees;
//        employees= employeeService.getEmployees();
//        employees.forEach(System.out :: println);
//
//
//        employees =EmployeeDAO.getBirthdayThisWeek();
//        employees.forEach(System.out :: println);
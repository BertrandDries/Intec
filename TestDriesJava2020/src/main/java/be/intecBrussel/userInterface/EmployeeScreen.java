package be.intecBrussel.userInterface;

import be.intecBrussel.services.EmployeeService;

import java.sql.Date;
import java.sql.SQLException;

public class EmployeeScreen {
    public static void start() throws SQLException {
        System.out.println(
                        " \n 1. List all employees."+
                        " \n 2. Add employee." +
                        " \n 3. Remove Employee."+
                        " \n 4. Update Employee."+
                        " \n 5. Search Employee by name."+
                        " \n 6. Look at anniversaries for the upcoming week."+
                        " \n 7. Return to start menu."+
                        " \n What would you like to do?");
            employeeAction(Input.intInput());
    }

    private static void employeeAction(int choice) throws SQLException {
        switch(choice){
            case 1 :
                EmployeeService.getEmployees().forEach(System.out::println);
                start();
                break;
            case 2 :
                addEmployee();
                start();
                break;
            case 3 :
                System.out.println("Please enter ID of employee you wish to delete.");
                EmployeeService.deleteEmployee(Input.intInput());
                System.out.println("Employee Deleted.");
                start();
                break;
            case 4 :
                updateEmployee();
                start();
                break;
            case 5 :
                System.out.println("Please enter Employee name.");
                searchEmployee(Input.stringInput());
                start();
                break;
            case 6 :
                getBirthdays();
                start();
                break;
            case 7 :
                StartScreen.Start();
                break;
        }
    }

    private static void updateEmployee() throws SQLException {
        System.out.println("Please enter Employee ID.");
        int ID = Input.intInput();
        System.out.println(
                "1. Given name. \n" +
                "2. Name. \n" +
                "3. Number. \n" +
                "4. ICE number. \n" +
                "5. Date of birth. \n" +
                "6. Wages. \n"+
                "Please select field you wish to update: ");
        int i = Input.intInput();
        String choice = null;
        if (i > 0 && i < 7) {
            String data = null;
            switch (i) {
                case (1):
                    choice = "GivenName";
                    System.out.println("Please enter new given name.");
                    data = Input.stringInput();
                    break;
                case (2):
                    choice = "Name";
                    System.out.println("Please enter new name.");
                    data = Input.stringInput();
                    break;
                case (3):
                    choice = "Number";
                    System.out.println("Please enter new number.");
                    data = Input.stringInput();
                    break;
                case (4):
                    choice = "ICENumber";
                    System.out.println("Please enter new ICE number.");
                    data = Input.stringInput();
                    break;
                case (5):
                    choice = "DateOfBirth";
                    System.out.println("Please enter new date of birth.");
                    data = String.valueOf(Input.inputDate());
                    break;
            }
            EmployeeService.updateEmployee(ID, choice, data);
            System.out.println("Employee updated.");
        }
        else if (i == 6){
            choice = "Wages";
            System.out.println("Please enter new wages.");
            int data = Input.intInput();
            EmployeeService.updateEmployee(ID, choice, data);
            System.out.println("Employee updated.");
        }
        else{
            System.out.println("not a valid input.");
            updateEmployee();
        }

    }

    private static void addEmployee() throws SQLException {
        System.out.println("Please enter a  given name.");
        String givenName = Input.inputname();
        System.out.println("Please enter a name.");
        String name = Input.inputname();
        System.out.println("Please enter a phone number.");
        String number = Input.inputPhoneNumber();
        System.out.println("Please enter an In Case Of Emergency phone number.");
        String ICEnumber = Input.inputPhoneNumber();
        System.out.println("Please enter birthday.");
        Date date = Input.enterBirthday();
        System.out.println("Please enter Wages.");
        int wages = Input.inputwages();
        EmployeeService.addEmployee(givenName,name,number,ICEnumber,date,wages);
        System.out.println("Employee added.");
    }

    private static void searchEmployee ( String name) throws SQLException {
        EmployeeService.searchEmployees(name).forEach(System.out::println);
    }

    private static void getBirthdays() throws SQLException {
        EmployeeService.getBirthdays().forEach(System.out::println);
    }
}

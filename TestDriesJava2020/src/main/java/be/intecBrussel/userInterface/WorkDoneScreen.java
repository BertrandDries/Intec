package be.intecBrussel.userInterface;

import be.intecBrussel.model.WorkDone;
import be.intecBrussel.services.EmployeeService;
import be.intecBrussel.services.WorkDoneServices;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class WorkDoneScreen {
    public static void start() throws SQLException {
        System.out.println(
                        " \n 1. List all work done."+
                        " \n 2. Add work done." +
                        " \n 3. Delete work done."+
                        " \n 4. Update work done."+
                        " \n 5. Search work done by employee. (by ID)"+
                        " \n 6. Get most work done on project. (by ID)"+
                        " \n 7. Return to start menu."+
                        " \n What would you like to do?");
        workDoneAction(Input.intInput());
    }

    private static void workDoneAction(int choice) throws SQLException {
        if(!(choice>0 && choice<8)){
            System.out.println("Not a valid choice");
            start();
        }
        else {
            switch (choice) {
                case 1:
                    WorkDoneServices.getWorkDone().forEach(System.out::println);
                    start();
                    break;
                case 2:
                    addWorkDone();
                    start();
                    break;
                case 3:
                    deleteWorkDone();
                    start();
                    break;
                case 4:
                    updateWorkDone();
                    start();
                    break;
                case 5:
                    WorkDoneServices.getWorkDoneEmployee(Input.inputEmployeeID()).forEach(System.out::println);
                    start();
                    break;
                case 6:
                    System.out.println("Please enter project ID.");
                    List<WorkDone> workDoneList = WorkDoneServices.getWorkDoneMax(Input.intInput());
                    for(WorkDone workDone: workDoneList){
                        System.out.println(workDone.toString2());
                    }
                    start();
                    break;
                case 7:
                    StartScreen.Start();
                    break;
            }
        }
    }

    private static void updateWorkDone() throws SQLException {
        System.out.println("Please enter ID of employee.");
        int employeeID = Input.inputEmployeeID();
        System.out.println("Please enter ID of project.");
        int projectID = Input.inputProjectID();
        System.out.println(
                        "1. Employee ID. \n" +
                        "2. Project ID. \n" +
                        "3. Date. \n" +
                        "4. Hours worked. \n" +
                        "5. Remarks. \n"+
                        "Please select field you wish to update: ");
        int i = Input.intInput();
        String choice = null;
        if (i==1 || i==2 || i==4) {
            int data = 0;
            switch (i) {
                case (1):
                    choice = "EmployeeID";
                    System.out.println("Please enter new Employee ID.");
                    data = Input.inputEmployeeID();
                    break;
                case (2):
                    choice = "ProjectID";
                    System.out.println("Please enter Project ID.");
                    data = Input.inputProjectID();
                    break;
                case (4):
                    choice = "HoursWorked";
                    System.out.println("Please enter new hours worked.");
                    data = Input.inputwages();
                    break;
            }
            WorkDoneServices.updateWorkDone(employeeID,projectID,choice,data);
            System.out.println("Work done updated.");
        }
        else if (i == 3){
            choice = "DateOfWork";
            System.out.println("Please enter new date.");
            Date date = Input.inputDate();
            WorkDoneServices.updateWorkDone(employeeID,projectID,choice,date);
            System.out.println("Work done updated.");
        }
        else if (i == 5){
            choice = "Remarks";
            System.out.println("Please enter new remark.");
            String remark = Input.stringInput();
            WorkDoneServices.updateWorkDone(employeeID,projectID,choice,remark);
            System.out.println("Work done updated.");
        }
        else{
            System.out.println("not a valid input.");
            updateWorkDone();
        }

    }

    private static void addWorkDone() throws SQLException {
        int employeeID = Input.inputEmployeeID();
        int ProjectID = Input.inputProjectID();
        System.out.println("Please enter date of work.");
        Date date = Input.inputDate();
        System.out.println("Please enter hours worked.");
        int hoursWorked = Input.inputwages();
        System.out.println("Please enter remarks.");
        String remarks = Input.stringInput();
        WorkDoneServices.addWorkDone(employeeID,ProjectID,date,hoursWorked,remarks);
        System.out.println("Work done added.");
    }

    private static void deleteWorkDone() throws SQLException {
        System.out.println("Please enter ID of employee.");
        int employeeID = Input.inputEmployeeID();
        System.out.println("Please enter ID of project.");
        int projectID = Input.inputProjectID();
        WorkDoneServices.deleteWorkDone(employeeID,projectID);
        System.out.println("Work Deleted.");
    }
}

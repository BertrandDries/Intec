package be.intecBrussel.userInterface;

import be.intecBrussel.services.EmployeeService;
import be.intecBrussel.services.ProjectService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static int intInput(){
        int input = scanner.nextInt();
        return input;
    }

    public static String stringInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static String inputPhoneNumber(){
        String number = stringInput();
        while(!checknumber(number)){
            System.out.println("Not a valid phone number, a number must start with 04 and have 10 digits.");
            number = stringInput();
        }
        return number;
    }

    public static boolean checknumber(String number){
        if(number.length() == 10 && number.startsWith("04")){
            return true;
        }
        else return false;
    }

    public static String inputname(){
        String name = scanner.nextLine();
        if(!(name != null && !name.isEmpty())){
            System.out.println("Input not valid.");
            inputname();
        }
        return name;
    }

    public static int inputwages(){
        int input = scanner.nextInt();
        if(input == 0){
            System.out.println("Input not valid.");
            input = inputwages();
        }
        return input;
    }

    public static Date inputDate(){
        System.out.println("Please enter year. (YYYY)");
        String birthday = Input.stringInput();
        System.out.println("Please enter month. (MM)");
        birthday = birthday +"-"+ Input.stringInput();
        System.out.println("Please enter Day.(DD)");
        birthday = birthday +"-"+ Input.stringInput();
        return Date.valueOf(birthday);
    }

    public static boolean checkbirthyear(Date date){
        LocalDate dat = date.toLocalDate();
        if(Calendar.getInstance().get(Calendar.YEAR) - dat.getYear()< 18){
            System.out.println("Person too young to be an employee.");
            return false;
        }
        else return true;
    }

    public static Date enterBirthday(){
        Date date = inputDate();
        while(!checkbirthyear(date)){
            date = inputDate();
        }
        return date;
    }

    private static boolean validstartdate(Date date) {
        java.util.Date today = Calendar.getInstance().getTime();
        java.util.Date start = Date.valueOf(date.toString());
        System.out.println(today);
        System.out.println(start);
        return start.after(today);
    }

    public static Date inputStartDate(){
        Date date = inputDate();
        while(!validstartdate(date)){
            System.out.println("Project cannot start in the past.");
            date = inputDate();
        }
        return date;
    }

    public static Date[] inputProjectDates(){
        System.out.println("Please enter start date.");
        Date[] dates = new Date[2];
        dates[0] = inputStartDate();
        System.out.println("Please enter end date.");
        Date end = inputDate();
        while (!end.after(dates[0])){
            System.out.println("End date not after start date. \n Please enter end date.");
            end = inputDate();
        }
        dates[1] = end;
        return dates;
    }

    public static int inputEmployeeID() throws SQLException {
        System.out.println("Please enter employee ID");
        int input = Input.intInput();
        if(!EmployeeService.searchEmployeeID(input)){
            input=inputEmployeeID();
        }
        return input;
    }

    public static int inputProjectID() throws SQLException {
        System.out.println("Please enter project ID");
        int input = scanner.nextInt();
        if(!ProjectService.searchProjectID(input)){
            input=inputProjectID();
        }
        return input;
    }


}

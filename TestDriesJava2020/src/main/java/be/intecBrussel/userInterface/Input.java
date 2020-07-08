package be.intecBrussel.userInterface;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class Input {

    public static int intInput(){
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if(!(name != null && !name.isEmpty())){
            System.out.println("Input not valid.");
            inputname();
        }
        return name;
    }

    public static int inputwages(){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 0){
            System.out.println("Input not valid.");
            input = inputwages();
        }
        return input;
    }

    public static Date enterDate(){
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
        Date date = enterDate();
        while(!checkbirthyear(date)){
            date = enterDate();
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

    public static Date enterStartDate(){
        Date date = enterDate();
        while(!validstartdate(date)){
            System.out.println("Project cannot start in the past.");
            date = enterDate();
        }
        return date;
    }

    public static Date[] enterProjectDates(){
        System.out.println("Please enter start date.");
        Date[] dates = new Date[2];
        dates[0] = enterStartDate();
        System.out.println("Please enter end date.");
        Date end = enterDate();
        while (!end.after(dates[0])){
            System.out.println("End date not after start date. \n Please enter end date.");
            end = enterDate();
        }
        return dates;
    }


}

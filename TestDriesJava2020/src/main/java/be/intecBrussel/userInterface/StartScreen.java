package be.intecBrussel.userInterface;

import java.sql.SQLException;

public class StartScreen {
    public static void Start() throws SQLException {
        startscreen();
        int input = Input.intInput();
        if (input==1){
            EmployeeScreen.start();
        }
        else if (input ==2){
            ProjectScreen.start();
        }
        else if (input == 3){
            WorkDoneScreen.start();
        }
        else{
            System.out.println("Invalid input, please select 1,2 or 3.");
            Start();
        }
    }
    public static void startscreen(){
        System.out.println(
                        " \n 1. Go to employees database."+
                        " \n 2. Go to projects database." +
                        " \n 3. Go to project work database"+
                        " \n What would you like to do?");

    }
}

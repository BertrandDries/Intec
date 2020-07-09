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
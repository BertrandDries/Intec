package be.intecBrussel.userInterface;

import be.intecBrussel.services.ProjectRendabilityServices;
import be.intecBrussel.services.ProjectService;

import java.sql.Date;
import java.sql.SQLException;

public class ProjectScreen {
    public static void start() throws SQLException {
        System.out.println(
                        " \n 1. List all Projects."+
                        " \n 2. Add a project." +
                        " \n 3. Remove a project."+
                        " \n 4. List all ongoing projects."+
                        " \n 5. List all projects starting today."+
                        " \n 6. Get project rendability"+
                        " \n 7. Return to start menu."+
                        " \n What would you like to do?");
        projectAction(Input.intInput());
    }

    private static void projectAction(int choice) throws SQLException {
        if(choice >7 || choice<1){
            System.out.println("Not a valid choice");
            start();
        }
        else{
            switch(choice){
                case 1 :
                    ProjectService.getProjects().forEach(System.out::println);
                    start();
                    break;
                case 2 :
                    addProject();
                    start();
                    break;
                case 3 :
                    System.out.println("Enter project ID you wish to delete");
                    ProjectService.deleteProject(Input.intInput());
                    System.out.println("Project Deleted.");
                    start();
                    break;
                case 4 :
                    ProjectService.getProjectsOngoing().forEach(System.out::println);
                    start();
                    break;
                case 5 :
                    ProjectService.getProjectsStartingToday().forEach(System.out::println);
                    start();
                    break;
                case 6 :
                    ProjectRendabilityServices.getProjectRendability().forEach(System.out::println);
                    start();
                    break;
                case 7 :
                    StartScreen.Start();
                    break;
            }
        }
    }

    private static void addProject() throws SQLException {
        System.out.println("Please enter project dates");
        Date[] dates = Input.inputProjectDates();
        System.out.println("Please enter project price");
        int price = Input.inputwages();
        System.out.println("Please enter project description");
        String description = Input.stringInput();
        ProjectService.addProject(dates[0], dates[1], price, description);
        System.out.println("Project added.");

    }
}

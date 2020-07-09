package be.intecBrussel.services;

import be.intecBrussel.connectivity.EmployeeDAO;
import be.intecBrussel.connectivity.ProjectDAO;
import be.intecBrussel.model.Project;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    public static List<Project> getProjects() throws SQLException {
        return ProjectDAO.getProjects();
    }
    public static List<Project> getProjectsOngoing() throws SQLException {
        return ProjectDAO.getProjectsOngoing();
    }
    public static List<Project> getProjectsStartingToday() throws SQLException {
        return ProjectDAO.getProjectsStartingToday();
    }

    public static void deleteProject(int projectID) throws SQLException {
        ProjectDAO.deleteProject(projectID);
    }

    public static void addProject(Date start, Date end, int price, String description) throws SQLException {
        Project project = new Project(0,start,end,price, description);
        ProjectDAO.addProject(project);
    }

    public static boolean searchProjectID(int ID) throws SQLException {
        if(ProjectDAO.searchProjectID(ID).isEmpty()){
            return false;
        }
        else return true;
    }
}

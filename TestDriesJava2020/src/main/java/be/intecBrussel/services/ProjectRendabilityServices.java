package be.intecBrussel.services;

import be.intecBrussel.connectivity.EmployeeDAO;
import be.intecBrussel.connectivity.WorkDoneDAO;
import be.intecBrussel.model.Project;
import be.intecBrussel.model.ProjectRendability;
import be.intecBrussel.model.WorkDone;
import javafx.beans.property.IntegerProperty;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRendabilityServices {

    public static List<ProjectRendability> getProjectRendability() throws SQLException {
        List<Project> projects= ProjectService.getProjects();
        List<ProjectRendability> projectRendabilities = new ArrayList<>();
        for (Project project : projects) {
            ProjectRendability projectRendability = new ProjectRendability();
            projectRendability.setProjectPrice(project.getPrice());
            projectRendability.setProjectID(project.getProjectID());
            List<WorkDone> workDones = WorkDoneDAO.getWorkFromProjectID(project.getProjectID());
            for(WorkDone workDone : workDones){
               double wages = EmployeeDAO.getEmployeeWages(workDone.getEmployeeID());
               double hours = workDone.getHoursWorked();
               projectRendability.addhours((int)hours);
               double wagesPerHour = (wages/22)/8;
               int costForProject = (int)(wagesPerHour * hours);
               projectRendability.addCost(costForProject);
               projectRendability.setRendability(projectRendability.getProjectPrice()-projectRendability.getTotalCost());
            }
            projectRendabilities.add(projectRendability);
        }
        return projectRendabilities;
    }
}

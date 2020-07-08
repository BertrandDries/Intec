package be.intecBrussel.connectivity;

import be.intecBrussel.model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {

    public static List<Project> parseResult(ResultSet resultSet) throws SQLException {
        List<Project> projects = new ArrayList<>();
        while(resultSet.next()){
            Project project = new Project(
                    resultSet.getInt("ProjectID"),
                    resultSet.getDate("Start"),
                    resultSet.getDate("End"),
                    resultSet.getInt("Price"),
                    resultSet.getString("Description")
            );
            projects.add(project);
        }
        return projects;
    }

    public static List<Project> getProjects() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM Projects";
        ResultSet resultSet = statement.executeQuery(sql);
        return parseResult(resultSet);
    }

    public static void addProject(Project project) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql =  "INSERT INTO Projects (Start,End,Price,Description) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setDate(1, project.getStart());
        preparedStatement.setDate(2, project.getEnd());
        preparedStatement.setInt(3, project.getPrice());
        preparedStatement.setString(4, project.getDescription());
        preparedStatement.executeUpdate();
    }

    public static void deleteProject(int projectID) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql =" DELETE FROM Projects WHERE ProjectID = ?";
        PreparedStatement preparedStatement= conn.prepareStatement(sql);
        preparedStatement.setInt(1, projectID);
        preparedStatement.executeUpdate();
    }

    public static List<Project> getProjectsOngoing() throws SQLException{
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM Projects WHERE End > NOW()";
        ResultSet resultSet = statement.executeQuery(sql);
        return parseResult(resultSet);
    }

    public static List<Project> getProjectsStartingToday() throws SQLException{
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM Projects WHERE DATE_FORMAT(Start, '%y-%m-%d') = DATE_FORMAT(NOW(),'%y-%m-%d')";
        ResultSet resultSet = statement.executeQuery(sql);
        return parseResult(resultSet);
    }
}

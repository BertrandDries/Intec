package frontEnd;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import model.Course;
import model.User;
import service.CourseService;
import service.LoginService;
import service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class StudentController {

    private static Stage primaryStage = new Stage();
    public Tab Profile;
    public ListView<String> CourseListBox;
    public Label Course1Label;
    public User user;

    public void display(String loginID) throws IOException {
        Parent root = FXMLLoader.load(new File("C:/Users/Dries/IdeaProjects/school's out/src/main/java/frontEnd/Student.fxml").toURI().toURL());
        primaryStage.setScene(new Scene(root,600,530));
        primaryStage.show();
        user = LoginService.getUserFromLoging(loginID);
        user.setActiveCourses(new ArrayList<Course>());
        fillCoursesList(root);
    }

    @FXML
    public void fillCoursesList(Parent root){
        CourseListBox = (ListView<String>) root.lookup("#CourseListBox");
        for(Course course : CourseService.getAllCourses()){
            System.out.println(CourseListBox);
            CourseListBox.getItems().addAll(course.toString());
        }
    }

    public void subscribeCourseButton(){
        CourseListBox.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        CourseListBox.getSelectionModel().getSelectedItems();
        this.user.addCourse(Integer.parseInt(CourseListBox.getSelectionModel().getSelectedItems().get(0).substring(0,1)));
    }

    public void setUser(User user) {
        this.user = user;
    }
}

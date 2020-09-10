package frontEnd;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import service.LoginService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;


public class LoginController {
    private static Stage primaryStage = new Stage();
    public Button LoginButton;

    public static void start() throws IOException {
        Parent root = FXMLLoader.load(new File("C:/Users/Dries/IdeaProjects/school's out/src/main/java/frontEnd/Login.fxml").toURI().toURL());
        primaryStage.setScene(new Scene(root,350,400));
        primaryStage.show();
    }


    @FXML
    private TextField UserIDField;
    @FXML
    private PasswordField UserPasswordField;
    @FXML
    private Label InvalidLoginField;

    public void LoginButtonOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        if (LoginService.login(UserIDField.getText(),UserPasswordField.getText())){
            StudentController studentController = new StudentController();
            /*studentController.setUser(LoginService.getUserFromLoging(UserIDField.getText()));*/
            studentController.display(UserIDField.getText());
            primaryStage.close();
        }
        else{
            InvalidLoginField.setVisible(true);
        }

    }
    public void CreateAccountButtonOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        CreateAccountController createAccountController = new CreateAccountController();
        createAccountController.display();
    }
}

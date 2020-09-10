package frontEnd;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.UserType;
import service.LoginService;
import service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CreateAccountController {
    private static Stage primaryStage = new Stage();

    @FXML
    private TextField UserNameField;
    @FXML
    private TextField FirstNameField;
    @FXML
    private TextField FamilyNameField;
    @FXML
    private TextField PasswordField1;
    @FXML
    private PasswordField PasswordField2;
    @FXML
    private ChoiceBox<String> UserTypeChoiceBox;
    @FXML
    private Button CreateButton;
    @FXML
    private Label UsernameNotAvailable;
    @FXML
    private Label PasswordsDoNotMatch;
    
    public void display() throws IOException {
        Parent root = FXMLLoader.load(new File("C:/Users/Dries/IdeaProjects/school's out/src/main/java/frontEnd/CreateAccount.fxml").toURI().toURL());
        primaryStage.setScene(new Scene(root,600,530));
        primaryStage.show();
    }

    public void CreateButtonOnAction(javafx.event.ActionEvent actionEvent) throws IOException {

        if(LoginService.verifyLogin(UserNameField.getText())){
            UsernameNotAvailable.setVisible(true);
        }
        else if(!PasswordField1.getText().equals(PasswordField2.getText()) ){
            PasswordsDoNotMatch.setVisible(true);
        }
        else{
            LoginService.createLogin(UserNameField.getText(),PasswordField1.getText(),UserService.createUser(FirstNameField.getText(),FamilyNameField.getText(), UserTypeChoiceBox.getValue()));
            WaitForValidationController.display();
            primaryStage.close();
        }
    }
}

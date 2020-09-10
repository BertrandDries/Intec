package frontEnd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class WaitForValidationController {
    private static Stage primaryStage = new Stage();
    public Button returnButton;


    public static void display() throws IOException {
        Parent root = FXMLLoader.load(new File("C:/Users/Dries/IdeaProjects/school's out/src/main/java/frontEnd/WaitForValidation.fxml").toURI().toURL());
        primaryStage.setScene(new Scene(root,400,500));
        primaryStage.show();
    }
    public  void returnButtonOnAction(ActionEvent event){
        primaryStage.close();
    }
}

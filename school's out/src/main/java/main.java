import frontEnd.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Course;
import model.Login;
import model.User;
import model.UserType;
import repository.ConnectionFactory;
import service.LoginService;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        LoginController.start();

        UserType Admin = new UserType();
        Admin.setUserType("Admin");
        UserType Teacher = new UserType();
        Teacher.setUserType("Teacher");
        UserType Student = new UserType();
        Student.setUserType("Student");

        Login DriesBertrand = new Login();
        DriesBertrand.setActive(true);
        DriesBertrand.setPasswordHash("1234");
        DriesBertrand.setLogin("DrBe00");

        Course course1 = new Course().setCourseName("lol").setDescription("stuff");
        Course course2 = new Course().setCourseName("lol2").setDescription("stuff2");

        User DrBe00 = new User();
        DrBe00.setUserType(Admin);
        DrBe00.setName("Dries");
        DrBe00.setFamilyName("Bertrand");
        DriesBertrand.setUser(DrBe00);

        EntityManager em = connectionFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(course1);
        em.persist(course2);
        em.persist(Admin);
        em.persist(Teacher);
        em.persist(Student);
        em.persist(DrBe00);
        em.persist(DriesBertrand);
        em.getTransaction().commit();


        LoginService.createLogin("Admin007", "Admin007",DrBe00);
        LoginService.verifyLogin("Admin007");
        em.close();
    }
}

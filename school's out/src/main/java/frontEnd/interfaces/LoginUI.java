package frontEnd.interfaces;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Login;
import model.User;
import model.UserType;
import repository.ConnectionFactory;
import service.LoginService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.UnsupportedEncodingException;

public class LoginUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws UnsupportedEncodingException {
        ConnectionFactory connectionFactory = new ConnectionFactory();



        UserType Admin = new UserType();
        Admin.setUserType("Admin");
        UserType Teacher = new UserType();
        Admin.setUserType("Teacher");
        UserType Student = new UserType();
        Admin.setUserType("Student");
        Login DriesBertrand = new Login();
        DriesBertrand.setActive(true);
        DriesBertrand.setPasswordHash("1234");
        DriesBertrand.setLogin("DrBe00");
        User DrBe00 = new User();
        DrBe00.setUserType(Admin);
        DrBe00.setName("Dries");
        DrBe00.setFamilyName("Bertrand");
        DriesBertrand.setUser(DrBe00);




        EntityManager em = connectionFactory.getEntityManager();
        EntityTransaction et =  em.getTransaction();
        et.begin();
        em.persist(Admin);
        em.persist(Teacher);
        em.persist(Student);
        em.persist(DrBe00);
        em.persist(DriesBertrand);
        et.commit();
        em.close();

        LoginService.createLogin("Admin007", "Admin007");
        LoginService.validateLogin("Admin007");
        System.out.println(LoginService.login("Admin007", "Admin007"));

    }
}

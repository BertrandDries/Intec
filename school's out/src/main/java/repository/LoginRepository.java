package repository;

import model.Login;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LoginRepository {
    public static Boolean login(String login, String passwoord){
        ConnectionFactory CF = new ConnectionFactory();


        EntityManager em = ConnectionFactory.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.find(Login.class, "Admin").getPasswordHash();


        et.commit();
        em.close();
        return true;
    }
}

package repository;

import model.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LoginRepository {

    public static Login getLoginAccount(String loginName){
        EntityManager em = ConnectionFactory.getEntityManager();
        return em.find(Login.class, loginName);
    }

    public static boolean verifyLoginExists(String loginName){
        EntityManager em = ConnectionFactory.getEntityManager();
        if(em.find(Login.class, loginName) != null){
            return true;
        }
        else return false;
    }

    public static void createLogin(Login login){
        EntityManager em = ConnectionFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(login);
        em.getTransaction().commit();
        em.close();
    }

    public static void validateLogin(String login) {
        EntityManager em = ConnectionFactory.getEntityManager();
        EntityTransaction et =  em.getTransaction();
        et.begin();
        em.persist(em.find(Login.class, login).setActive(true));
        et.commit();
        em.close();
    }
}

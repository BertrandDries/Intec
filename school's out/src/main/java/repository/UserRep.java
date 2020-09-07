package repository;

import model.User;

import javax.persistence.EntityManager;

public class UserRep {
    public static void createUser(User user){
        EntityManager em = ConnectionFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public static User getUser(int id){
        return ConnectionFactory.getEntityManager().find(User.class, id);
    }
}

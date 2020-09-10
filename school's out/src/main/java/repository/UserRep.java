package repository;

import model.Course;
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
        EntityManager em = ConnectionFactory.getEntityManager();
        return em.find(User.class, id);
    }

    public static void addnewCourse(int userId, int courseId){
        EntityManager em = ConnectionFactory.getEntityManager();
        User user = em.find(User.class, userId);
        user.getActiveCourses().add(em.find(Course.class,courseId));
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
    public static void moveCourseToFinished(int userId, int courseId){
        EntityManager em = ConnectionFactory.getEntityManager();
        User user = em.find(User.class, userId);
        user.getActiveCourses().remove(em.find(Course.class,courseId));
        user.getFnishedCourses().add(em.find(Course.class,courseId));
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();

    }
}

package repository;

import model.Course;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CourseRep {


    public static Course getCourse(int id){
        EntityManager em = ConnectionFactory.getEntityManager();
        return em.find(Course.class, id);
    }
    public static List<Course> getAllCourses(){
        EntityManager em = ConnectionFactory.getEntityManager();
        Query query = em.createQuery("FROM Course c");
        return query.getResultList();
    }

    public static void createCourse(Course course){
        EntityManager em = ConnectionFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    public static void deleteCourse(int id) {
        EntityManager em = ConnectionFactory.getEntityManager();
        em.remove(em.find(Course.class, id));
    }

}

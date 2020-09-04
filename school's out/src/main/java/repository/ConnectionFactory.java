package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    private static EntityManagerFactory emf;

    public ConnectionFactory(){
        if(emf == null) emf = Persistence.createEntityManagerFactory("datasource");
    }

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

}

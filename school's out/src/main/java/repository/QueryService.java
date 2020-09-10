package repository;

import model.UserType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class QueryService {
    @PersistenceContext(unitName = "DynamicQueries")
    private static EntityManager em = ConnectionFactory.getEntityManager();

    public static UserType getUserType(String ut){
        String sql = "FROM UserType U where U.userType = :ut";
        javax.persistence.Query query = em.createQuery(sql,UserType.class);
        query.setParameter("ut",ut);
        List result = query.getResultList();
        return (UserType) result.get(0);
    }
}

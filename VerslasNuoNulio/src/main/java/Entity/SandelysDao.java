package Entity;

import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class SandelysDao {

    public List<Sandelys> getAllPrekes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        List<Sandelys> prekesByName = (List<Sandelys>) session.createQuery(
                "FROM Sandelys s ORDER BY s.id ASC").list();

        session.getTransaction().commit();
        session.close();
        return prekesByName;
    }
}
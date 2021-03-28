package Entity;

import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class ParduotuveDao {

    public static List<Parduotuve> getAllPrekes() {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            @SuppressWarnings("unchecked")
            List<Parduotuve> prekesByName = (List<Parduotuve>) session.createQuery(
                    "FROM Preke s left join Entity.Parduotuve a on s.id = a.prekesid ORDER BY s.id ASC").list();

            session.getTransaction().commit();
            session.close();
            return prekesByName;
        }
    }


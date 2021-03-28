package Entity;

import org.hibernate.Session;
import Util.HibernateUtil;

import java.util.List;

public class PardavimaiDao {

    public static List<Pardavimai> getParduotosPrekes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        List<Pardavimai> parduotosPrekes = (List<Pardavimai>) session.createQuery(
                "FROM Preke s left join Entity.Pardavimai a on s.id = a.prekesid ORDER BY s.id ASC").list();

        session.getTransaction().commit();
        session.close();
        return parduotosPrekes;
    }
}

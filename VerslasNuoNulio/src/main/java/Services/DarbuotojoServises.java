package Services;

import Entity.Pardavimai;
import Entity.Parduotuve;
import Entity.Sandelys;
import Util.HibernateUtil;
import org.hibernate.Session;
import repository.sandelys.SandelysRepository;

import java.util.List;

public class DarbuotojoServises {
    public DarbuotojoServises(SandelysRepository sandelysRepository) {
    }
    public static List<Parduotuve> prekiuLikutisParduotuveje() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        List<Parduotuve> prekesByName = (List<Parduotuve>) session.createQuery(
                "FROM Preke s left join Entity.Parduotuve a on s.id = a.prekesid ORDER BY s.id ASC").list();

        session.getTransaction().commit();
        session.close();
        return prekesByName;
    }

    public List<Sandelys> prekiuLikutisSandelyje() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        List<Sandelys> prekesByName = (List<Sandelys>) session.createQuery(
                "FROM Preke s left join Entity.Sandelys a on s.id = a.prekesid ORDER BY s.id ASC").list();

        session.getTransaction().commit();
        session.close();
        return prekesByName;
    }
    public static List<Pardavimai> pardavimaiList() {
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

package Services;

import Entity.Pardavimai;
import Entity.Parduotuve;
import Entity.Preke;
import Entity.Sandelys;
import Util.HibernateUtil;
import org.hibernate.Session;
import repository.pirkejas.PirkejasRepository;
import repository.sandelys.SandelysRepository;

import java.util.List;

public class DarbuotojoServises {

    private final SandelysRepository sandelysRepository;

    public DarbuotojoServises(SandelysRepository sandelysRepository) {
        this.sandelysRepository = sandelysRepository;
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
    public Preke uzsakytiNaujaPrekiu(String pavadinimas, String kategorija, String spalva, double kaina ){
        Preke preke = new Preke(pavadinimas, kategorija, spalva, kaina);
        sandelysRepository.save(preke);
        return preke;
    }

}

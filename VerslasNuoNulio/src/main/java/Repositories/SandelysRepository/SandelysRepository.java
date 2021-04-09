package Repositories.SandelysRepository;

import Entity.Parduotuve;
import Entity.Preke;
import Entity.Sandelys;
import Repositories.AbstractRepository;
import Utils.Utils;
import org.hibernate.Session;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class SandelysRepository extends AbstractRepository {
    public SandelysRepository(EntityManager entityManager) {
        super(entityManager, Sandelys.class);
    }

    @Override
    public List findAll() {
        return entityManager.createQuery("FROM Sandelys where kiekis > 0", Sandelys.class).getResultList();
    }

    public List ispetiApiePrekesUzsakyma() {
        return entityManager.createQuery("FROM Sandelys where kiekis < 2", Sandelys.class).getResultList();
    }

    public void findPrekeByIdUpdateKiekis(long fragmentID, int kiekisFragment) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Sandelys set kiekis = kiekis - :kiekisFragment where id = :idFragment");
        query.setParameter("idFragment", fragmentID);
        query.setParameter("kiekisFragment", kiekisFragment);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    //    public List availablePrekes() {
//        String uzklausa = "select preke_id, pavadinimas, kategorija, spalva, \n" +
//                "sum(a.kiekis + par.kiekis) as prekiuKiekis\n" +
//                "from Sandelys a\n" +
//                "inner join Preke p on p.id = a.preke_id\n" +
//                "inner join Parduotuve par on a.id = par.preke_id\n" +
//                "group by pavadinimas\n" +
//                "ORDER BY spalva";
//        return entityManager.createQuery(uzklausa).getResultList();
//    }
//    public void prekiuSarasas() {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Sandelys> q = cb.createQuery(Sandelys.class);
//        Root<Sandelys> sandelysRoot = q.from( Sandelys.class );
//        Join<Sandelys,Preke> prekeSand = sandelysRoot.join("PREKE_ID" );
//        Join<Preke, Parduotuve> prekePard = prekeSand.join("PREKE_ID");
//        q.multiselect(sandelysRoot.get("PREKE_ID"), cb.sum(sandelysRoot.get("kiekis")));
//        q.groupBy(sandelysRoot.get("Pavadinimas"));
//    }
    public void findAllbySpalva() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sandelys> query = cb.createQuery(Sandelys.class);
        Root<Sandelys> c = query.from(Sandelys.class);
        c.join("preke");
        query.select(c).distinct(true).orderBy(cb.desc(c.get("Preke.Spalva")));
        TypedQuery<Sandelys> typedQuery = entityManager.createQuery(query);
        typedQuery.getResultList().forEach(System.out::println);
    }
}



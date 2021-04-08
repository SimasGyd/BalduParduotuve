package Repositories.SandelysRepository;

import Entity.Sandelys;
import Repositories.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

        Query query = entityManager.createQuery("UPDATE Sandelys set kiekis = kiekis - :kiekisFragment where id = :idFragment");
        query.setParameter("idFragment", fragmentID);
        query.setParameter("kiekisFragment", kiekisFragment);
    }
}

//    UPDATE sandelys set kiekis = kiekis - 5 where id = 1
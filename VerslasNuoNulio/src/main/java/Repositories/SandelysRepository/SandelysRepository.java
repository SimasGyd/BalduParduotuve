package Repositories.SandelysRepository;

import Entity.Sandelys;
import Repositories.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
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

    @Transactional
    public void findPrekeByIdUpdateKiekis(long fragmentID, int kiekisFragment) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Sandelys set kiekis = kiekis - :kiekisFragment where id = :idFragment");
        query.setParameter("idFragment", fragmentID);
        query.setParameter("kiekisFragment", kiekisFragment);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

}



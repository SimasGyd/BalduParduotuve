package Repositories.ParduotuveRepository;

import Entity.Parduotuve;
import Entity.Sandelys;
import Repositories.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ParduotuveRepository extends AbstractRepository {
    public ParduotuveRepository(EntityManager entityManager) {
        super(entityManager, Parduotuve.class);
    }

    @Override
    public List<Parduotuve> findAll() {
        return entityManager.createQuery("FROM Parduotuve where kiekis > 0", Parduotuve.class).getResultList();
    }
    public void findPrekeByIdUpdateKiekisPard(long fragmentID, int kiekisFragment) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Parduotuve set kiekis = kiekis + :kiekisFragment where id = :idFragment");
        query.setParameter("idFragment", fragmentID);
        query.setParameter("kiekisFragment", kiekisFragment);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}

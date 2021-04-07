package Repositories.ParduotuveRepository;

import Entity.Parduotuve;
import Repositories.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ParduotuveRepository extends AbstractRepository {
    public ParduotuveRepository(EntityManager entityManager) {
        super(entityManager, Parduotuve.class);
    }

    @Override
    public List<Parduotuve> findAll() {
        return entityManager.createQuery("FROM Parduotuve where kiekis > 0", Parduotuve.class).getResultList();
    }
}

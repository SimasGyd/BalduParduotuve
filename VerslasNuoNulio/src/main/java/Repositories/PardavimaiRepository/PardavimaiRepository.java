package Repositories.PardavimaiRepository;

import Entity.Pardavimai;
import Repositories.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class PardavimaiRepository extends AbstractRepository<Pardavimai, Long> {
    public PardavimaiRepository(EntityManager entityManager) {
        super(entityManager, Pardavimai.class);
    }

    @Override
    public List<Pardavimai> findAll() {
        return entityManager.createQuery("FROM Pardavimai where kiekis > 0", Pardavimai.class).getResultList();
    }
}

package repository.pirkejas;

import Entity.Pardavimai;
import repository.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class PirkejasRepository extends AbstractRepository {

    public PirkejasRepository(EntityManager entityManager) {
        super(entityManager, Pardavimai.class);
    }

    @Override
    public List findAll() {
        return null;
    }
}

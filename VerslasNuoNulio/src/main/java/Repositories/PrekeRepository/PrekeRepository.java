package Repositories.PrekeRepository;

import Entity.Preke;
import Repositories.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class PrekeRepository extends AbstractRepository<Preke, Long> {
    public PrekeRepository(EntityManager entityManager) { super(entityManager, Preke.class);}

    @Override
    public List<Preke> findAll() {
        return entityManager.createQuery("FROM Preke", Preke.class).getResultList();
    }
}

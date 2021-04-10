package Repositories.PrekeRepository;

import Entity.Parduotuve;
import Entity.Preke;
import Entity.Sandelys;
import Repositories.AbstractRepository;
import Servises.SandelysServise;

import javax.persistence.EntityManager;
import java.util.List;

public class PrekeRepository extends AbstractRepository<Preke, Long> {
    public PrekeRepository(EntityManager entityManager) {
        super(entityManager, Preke.class);
    }

    @Override
    public List findAll() {
        return entityManager().createQuery("FROM Preke", Preke.class).getResultList();
    }



    }


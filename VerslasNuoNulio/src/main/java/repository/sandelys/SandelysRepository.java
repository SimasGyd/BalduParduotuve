package repository.sandelys;

import Entity.Sandelys;
import repository.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class SandelysRepository extends AbstractRepository<Sandelys, Long> {
    public SandelysRepository(EntityManager entityManager) {
        super(entityManager, Sandelys.class);
    }

    @Override
    public List<Sandelys> findAll() {
        return entityManager.createQuery("FROM Sandelys", Sandelys.class).getResultList();
    }

//    public List<Sandelys> searchByNameFragmentSandelys(String fragment) {
//        Query query = entityManager.createQuery("FROM Book WHERE name LIKE :nameFragment", Sandelys.class);
//        query.setParameter("nameFragment", "%" + fragment + "%");
//        return query.getResultList();
//    }
}



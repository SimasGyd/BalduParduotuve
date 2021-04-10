package Repositories.PardavimaiRepository;

import Entity.Pardavimai;
import Repositories.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PardavimaiRepository extends AbstractRepository<Pardavimai, Long> {
    public PardavimaiRepository(EntityManager entityManager) {
        super(entityManager, Pardavimai.class);
    }

    @Override
    public List<Pardavimai> findAll() {
        return entityManager().createQuery("FROM Pardavimai where kiekis > 0", Pardavimai.class).getResultList();
    }
    public void findPrekeByIdUpdateKiekisPardavimai(long fragmentID, int kiekisFragment) {
        EntityManager entityManager = entityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Pardavimai set kiekis = kiekis + :kiekisFragment where id = :idFragment");
        query.setParameter("idFragment", fragmentID);
        query.setParameter("kiekisFragment", kiekisFragment);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}

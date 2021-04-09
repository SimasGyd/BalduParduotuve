package Repositories.PrekeRepository;

import Entity.Preke;
import Repositories.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class PrekeRepository extends AbstractRepository<Preke, Long> {
    public PrekeRepository(EntityManager entityManager) { super(entityManager, Preke.class);}

    @Override
    public List findAll() {
        return entityManager.createQuery("FROM Preke", Preke.class).getResultList();
    }

public List availablePrekes(){
        String uzklausa = "select preke_id, pavadinimas, kategorija, spalva, \n" +
                "sum(a.kiekis + par.kiekis) as prekiuKiekis\n" +
                "from Preke p\n" +
                "inner join Sandelys a on p.id = a.preke_id\n" +
                "inner join Parduotuve par on p.id = par.preke_id\n" +
                "group by pavadinimas\n" +
                "ORDER BY spalva";
        return entityManager.createQuery(uzklausa).getResultList();
}

}

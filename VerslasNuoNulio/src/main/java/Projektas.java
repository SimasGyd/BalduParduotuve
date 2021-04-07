import Controller.Darbuotojas.DarbuotojasController;
import Controller.Entry.EntryController;
import Controller.Pirkejas.PirkejasController;
import Data.DataImport;
import Entity.Pardavimai;
import Entity.Parduotuve;
import Entity.Preke;
import Entity.Sandelys;
import Repositories.PardavimaiRepository.PardavimaiRepository;
import Repositories.ParduotuveRepository.ParduotuveRepository;
import Repositories.PrekeRepository.PrekeRepository;
import Repositories.SandelysRepository.SandelysRepository;
import Servises.PardavimaiServise;
import Servises.ParduotuveServise;
import Servises.PrekeServise;
import Servises.SandelysServise;
import Utils.Input.DefaultInputReceiver;
import Utils.Input.InputReceiver;
import Utils.Output.DefaultOutputProducer;
import Utils.Output.OutputProducer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class Projektas {


    public static final String HIBERNATE_CONFIGURATION = "hibernate.cfg.xml";

    public Projektas() {
        constructEntryController(entityManager()).run();
    }

    private EntryController constructEntryController(EntityManager entityManager) {
        InputReceiver receiver = new DefaultInputReceiver();
        OutputProducer output = new DefaultOutputProducer();

        DataImport dataImport = new DataImport();
        dataImport.addPrekes();

        PrekeServise prekeServise = new PrekeServise(new PrekeRepository(entityManager));
        PardavimaiServise pardavimaiServise = new PardavimaiServise(new PardavimaiRepository(entityManager));
        SandelysServise sandelysServise = new SandelysServise(new SandelysRepository(entityManager), prekeServise);
        ParduotuveServise parduotuveServise = new ParduotuveServise(new ParduotuveRepository(entityManager));

        DarbuotojasController darbuotojasController = new DarbuotojasController(prekeServise, parduotuveServise, sandelysServise, pardavimaiServise, receiver, output);
        PirkejasController pirkejasController = new PirkejasController(prekeServise, receiver, output);
        return new EntryController(darbuotojasController, pirkejasController, receiver, output);
    }

    private EntityManager entityManager() {
        SessionFactory sessionFactory = new Configuration()
                .configure(HIBERNATE_CONFIGURATION)
                .addAnnotatedClass(Preke.class)
                .addAnnotatedClass(Pardavimai.class)
                .addAnnotatedClass(Sandelys.class)
                .addAnnotatedClass(Parduotuve.class)
                .buildSessionFactory();

        return sessionFactory.createEntityManager();
    }
}


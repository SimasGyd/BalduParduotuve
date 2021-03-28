import Entity.Pardavimai;
import Entity.Parduotuve;
import Entity.Preke;
import Entity.Sandelys;
import Services.DarbuotojoServises;
import Services.PirkejoServises;
import Util.Input.DefaultInputReciever;
import Util.Input.InputReciever;
import Util.Output.DefaultOutputReciever;
import Util.Output.OutputReciever;
import Valdymas.Darbuotojas.DarbuotojoValdymas;
import Valdymas.Lobby.LobbyValdymas;
import Valdymas.Pirkejas.PirkejoValdymas;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.pirkejas.PirkejasRepository;
import repository.sandelys.SandelysRepository;

import javax.persistence.EntityManager;

public class Project {
    public static final String HIBERNATE_CONFIGURATION = "hibernate.cfg.xml";

    public Project() {
        constructEntryController(entityManager()).run();
    }

    private LobbyValdymas constructEntryController(EntityManager entityManager) {
        InputReciever receiver = new DefaultInputReciever();
        OutputReciever output = new DefaultOutputReciever();
        DarbuotojoServises darbuotojoServises = new DarbuotojoServises(new SandelysRepository(entityManager));
        PirkejoServises pirkejoServises = new PirkejoServises(new PirkejasRepository(entityManager), darbuotojoServises);

        PirkejoValdymas pirkejoValdymas = new PirkejoValdymas(darbuotojoServises, pirkejoServises, receiver, output);
        DarbuotojoValdymas darbuotojoValdymas = new DarbuotojoValdymas(darbuotojoServises, pirkejoServises, receiver, output);
        return new LobbyValdymas(pirkejoValdymas, darbuotojoValdymas, receiver, output);
    }

    private EntityManager entityManager() {
        SessionFactory sessionFactory = new Configuration()
                .configure(HIBERNATE_CONFIGURATION)
                .addAnnotatedClass(Sandelys.class)
                .addAnnotatedClass(Pardavimai.class)
                .addAnnotatedClass(Preke.class)
                .addAnnotatedClass(Parduotuve.class)
                .buildSessionFactory();

        return sessionFactory.createEntityManager();
    }
    }

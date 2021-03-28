import Entity.Sandelys;
import Entity.SandelysDao;
import Entity.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Sandelys sandelys = new Sandelys();
        SandelysDao sandelysDao = new SandelysDao();

        List<Sandelys> remainingPrekes = sandelysDao.getAllPrekes();
        System.out.println("List of all remaining Prekes in sandelys :");
        for (Sandelys sand : remainingPrekes) {
            System.out.println(sand);
        }
        Pardavimai pardavimai = new Pardavimai();
        PardavimaiDao pardavimaiDao = new PardavimaiDao();

        List<Pardavimai> parduotosPrekes = PardavimaiDao.getParduotosPrekes();
        System.out.println("List of all sold Prekes :");
        for (Pardavimai pard : parduotosPrekes) {
            System.out.println(pard);
        }
        Parduotuve parduotuve = new Parduotuve();
        ParduotuveDao parduotuveDao = new ParduotuveDao();

        List<Parduotuve> prekiuLikutis = ParduotuveDao.getAllPrekes();
        System.out.println("List of all remaining Prekes in parduotuve :");
        for (Parduotuve parda : prekiuLikutis) {
            System.out.println(parda);
        }
    }
}


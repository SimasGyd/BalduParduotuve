import Entity.Sandelys;
import Entity.SandelysDao;

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
    }
}


package Data;

import Entity.Pardavimai;
import Entity.Parduotuve;
import Entity.Preke;
import Entity.Sandelys;
import Utils.Utils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DataImport {
    public void addPrekes() {

        Session session = Utils.getSessionFactory().openSession();
        session.beginTransaction();

        Preke kingSizeBed = new Preke("King Size Bed", "Lova", "Juoda", 299.00);
        Preke royalChair = new Preke("Royal Chair", "Kede", "Auksine", 200.00);
        Preke woodenWardrobe = new Preke("Wooden Wardrobe", "Spinta", "Azuolo", 999.00);
        Preke woodenTable = new Preke("Wooden Table", "Stalas", "Azuolo", 600.00);
        Preke fluffyChair = new Preke("Fluffy Chair", "Kede", "Juoda", 100.00);
        Preke roundTable = new Preke("Round Table", "Stalas", "Black", 299.00);
        Preke kidBed = new Preke("Kid Bed", "Lova", "Balta", 129.00);
        Preke glassyTable = new Preke("Glassy Table", "Stalas", "Stiklo", 400.00);
        Preke heartBed = new Preke("Heart Bed", "Lova", "Raudona", 1099.00);
        Preke roundChair = new Preke("Round Chair", "Kede", "Melyna", 49.00);
        Preke mirroredWardrobe = new Preke("Mirrored Wardrobe", "Spinta", "Veidrodine", 799.00);

        Sandelys royalChairSand = new Sandelys(5);
        Parduotuve royalChairParduotuve = new Parduotuve(1);
        Pardavimai royalChairParduota = new Pardavimai(2);
        royalChair.getSandelysList().add(royalChairSand);
        royalChair.getParduotuveList().add(royalChairParduotuve);
        royalChair.getPardavimaiList().add(royalChairParduota);
        royalChairSand.setPreke(royalChair);
        royalChairParduotuve.setPreke(royalChair);
        royalChairParduota.setPreke(royalChair);

        Sandelys glassyTableSand = new Sandelys(4);
        Parduotuve glassyTableParduotuve = new Parduotuve(2);
        Pardavimai glassyTableParduota = new Pardavimai(0);
        glassyTable.getSandelysList().add(glassyTableSand);
        glassyTable.getParduotuveList().add(glassyTableParduotuve);
        glassyTable.getPardavimaiList().add(glassyTableParduota);
        glassyTableSand.setPreke(glassyTable);
        glassyTableParduotuve.setPreke(glassyTable);
        glassyTableParduota.setPreke(glassyTable);

        Sandelys fluffyChairSand = new Sandelys(9);
        Parduotuve fluffyChairParduotuve = new Parduotuve(1);
        Pardavimai fluffyChairParduota = new Pardavimai(3);
        fluffyChair.getSandelysList().add(fluffyChairSand);
        fluffyChair.getParduotuveList().add(fluffyChairParduotuve);
        fluffyChair.getPardavimaiList().add(fluffyChairParduota);
        fluffyChairSand.setPreke(fluffyChair);
        fluffyChairParduotuve.setPreke(fluffyChair);
        fluffyChairParduota.setPreke(fluffyChair);

        Sandelys kidBedSand = new Sandelys(12);
        Parduotuve kidBedParduotuve = new Parduotuve(1);
        Pardavimai kidBedParduota = new Pardavimai(2);
        kidBed.getSandelysList().add(kidBedSand);
        kidBed.getParduotuveList().add(kidBedParduotuve);
        kidBed.getPardavimaiList().add(kidBedParduota);
        kidBedSand.setPreke(kidBed);
        kidBedParduotuve.setPreke(kidBed);
        kidBedParduota.setPreke(kidBed);

        Sandelys roundChairSand = new Sandelys(9);
        Parduotuve roundChairParduotuve = new Parduotuve(1);
        Pardavimai roundChairParduota = new Pardavimai(3);
        roundChair.getSandelysList().add(roundChairSand);
        roundChair.getParduotuveList().add(roundChairParduotuve);
        roundChair.getPardavimaiList().add(roundChairParduota);
        roundChairSand.setPreke(roundChair);
        roundChairParduotuve.setPreke(roundChair);
        roundChairParduota.setPreke(roundChair);

        Sandelys mirroredWardrobeSand = new Sandelys(1);
        Parduotuve mirroredWardrobeParduotuve = new Parduotuve(1);
        Pardavimai mirroredWardrobeParduota = new Pardavimai(2);
        mirroredWardrobe.getSandelysList().add(mirroredWardrobeSand);
        mirroredWardrobe.getParduotuveList().add(mirroredWardrobeParduotuve);
        mirroredWardrobe.getPardavimaiList().add(mirroredWardrobeParduota);
        mirroredWardrobeSand.setPreke(mirroredWardrobe);
        mirroredWardrobeParduotuve.setPreke(mirroredWardrobe);
        mirroredWardrobeParduota.setPreke(mirroredWardrobe);

        Sandelys woodenTableSand = new Sandelys(3);
        Parduotuve woodenTableParduotuve = new Parduotuve(1);
        Pardavimai woodenTableParduota = new Pardavimai(1);
        woodenTable.getSandelysList().add(woodenTableSand);
        woodenTable.getParduotuveList().add(woodenTableParduotuve);
        woodenTable.getPardavimaiList().add(woodenTableParduota);
        woodenTableSand.setPreke(woodenTable);
        woodenTableParduotuve.setPreke(woodenTable);
        woodenTableParduota.setPreke(woodenTable);

        Sandelys kingSizeBedSand = new Sandelys(3);
        Parduotuve kingSizeBedParduotuve = new Parduotuve(1);
        Pardavimai kingSizeBedParduota = new Pardavimai(0);
        kingSizeBed.getSandelysList().add(kingSizeBedSand);
        kingSizeBed.getParduotuveList().add(kingSizeBedParduotuve);
        kingSizeBed.getPardavimaiList().add(kingSizeBedParduota);
        kingSizeBedSand.setPreke(kingSizeBed);
        kingSizeBedParduotuve.setPreke(kingSizeBed);
        kingSizeBedParduota.setPreke(kingSizeBed);

        Sandelys roundTableSand = new Sandelys(7);
        Parduotuve roundTableParduotuve = new Parduotuve(0);
        Pardavimai roundTableParduota = new Pardavimai(5);
        roundTable.getSandelysList().add(roundTableSand);
        roundTable.getParduotuveList().add(roundTableParduotuve);
        roundTable.getPardavimaiList().add(roundTableParduota);
        roundTableSand.setPreke(roundTable);
        roundTableParduotuve.setPreke(roundTable);
        roundTableParduota.setPreke(roundTable);

        Sandelys heartBedSand = new Sandelys(0);
        Parduotuve heartBedParduotuve = new Parduotuve(1);
        Pardavimai heartBedParduota = new Pardavimai(0);
        heartBed.getSandelysList().add(heartBedSand);
        heartBed.getParduotuveList().add(heartBedParduotuve);
        heartBed.getPardavimaiList().add(heartBedParduota);
        heartBedSand.setPreke(heartBed);
        heartBedParduotuve.setPreke(heartBed);
        heartBedParduota.setPreke(heartBed);

        Sandelys woodenWardrobeSand = new Sandelys(2);
        Parduotuve woodenWardrobeParduotuve = new Parduotuve(1);
        Pardavimai woodenWardrobeParduota = new Pardavimai(1);
        woodenWardrobe.getSandelysList().add(woodenWardrobeSand);
        woodenWardrobe.getParduotuveList().add(woodenWardrobeParduotuve);
        woodenWardrobe.getPardavimaiList().add(woodenWardrobeParduota);
        woodenWardrobeSand.setPreke(woodenWardrobe);
        woodenWardrobeParduotuve.setPreke(woodenWardrobe);
        woodenWardrobeParduota.setPreke(woodenWardrobe);


        session.persist(royalChair);
        session.persist(fluffyChair);
        session.persist(roundChair);
        session.persist(woodenTable);
        session.persist(glassyTable);
        session.persist(roundTable);
        session.persist(kidBed);
        session.persist(kingSizeBed);
        session.persist(heartBed);
        session.persist(woodenWardrobe);
        session.persist(mirroredWardrobe);
        session.getTransaction().commit();
        session.close();
    }
}

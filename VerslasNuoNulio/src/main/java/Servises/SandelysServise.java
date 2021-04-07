package Servises;

import Entity.Sandelys;
import Repositories.SandelysRepository.SandelysRepository;

import java.util.List;

public class SandelysServise {

    private final SandelysRepository sandelysRepository;
    private final PrekeServise prekeServise;

    public SandelysServise(SandelysRepository sandelysRepository, PrekeServise prekeServise) {
        this.sandelysRepository = sandelysRepository;
        this.prekeServise = prekeServise;
    }

    public List<Sandelys> findAllSandelys() {
        return sandelysRepository.findAll();
    }

    public List<Sandelys> uzsakytiPrekes() {
        return sandelysRepository.ispetiApiePrekesUzsakyma();
    }

    public Sandelys saveNewPrekeSand(int kiekis) {
        Sandelys sandelys = new Sandelys(kiekis);
        sandelysRepository.save(sandelys);
        return sandelys;



    }
}

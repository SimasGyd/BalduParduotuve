package Servises;

import Entity.Preke;
import Entity.Sandelys;
import Repositories.SandelysRepository.SandelysRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SandelysServise {

    private final SandelysRepository sandelysRepository;

    public SandelysServise(SandelysRepository sandelysRepository) {
        this.sandelysRepository = sandelysRepository;
    }

    public List<Sandelys> findAllSandelys() {
        return sandelysRepository.findAll();
    }

    public List<Sandelys> uzsakytiPrekes() {
        return sandelysRepository.ispetiApiePrekesUzsakyma();
    }

    public Sandelys saveNewPrekeSand(int kiekis, Preke preke) {
        Sandelys sandelys = new Sandelys(kiekis, preke);
        sandelysRepository.save(sandelys);
        return sandelys;}

    }


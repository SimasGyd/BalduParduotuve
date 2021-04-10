package Servises;

import Entity.Parduotuve;
import Entity.Preke;
import Entity.Sandelys;
import Repositories.ParduotuveRepository.ParduotuveRepository;

import java.util.List;

public class ParduotuveServise {
    private final ParduotuveRepository parduotuveRepository;

    public ParduotuveServise(ParduotuveRepository parduotuveRepository) {
        this.parduotuveRepository = parduotuveRepository;
    }

    public List<Parduotuve> findAllParduotuve() {
        return parduotuveRepository.findAll();
    }

    public void findPrekeByIdUpdateKiekisPard(long fragment, int kiekisFragment){
        parduotuveRepository.findPrekeByIdUpdateKiekisPard(fragment, kiekisFragment);
    }
    public Parduotuve saveNewPrekeParduotuve(int kiekis, Preke preke) {
        Parduotuve parduotuve = new Parduotuve(kiekis, preke);
        parduotuveRepository.save(parduotuve);
        return parduotuve;
    }

}

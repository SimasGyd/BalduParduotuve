package Servises;

import Entity.Preke;
import Entity.Sandelys;
import Repositories.PrekeRepository.PrekeRepository;

import java.util.Collection;
import java.util.List;

public class PrekeServise {

    private final PrekeRepository prekeRepository;

    public PrekeServise(PrekeRepository prekeRepository) {
        this.prekeRepository = prekeRepository;
    }


    public Preke saveNewPreke(String pavadinimas, String kategorija, String spalva, double kaina) {
        Preke preke = new Preke(pavadinimas, kategorija, spalva, kaina);
        prekeRepository.save(preke);
        return preke;
    }

    public Preke updatePreke(Preke preke) {
        prekeRepository.save(preke);
        return preke;
    }

    public List<Preke> findAllPrekes() {
        return prekeRepository.findAll();
    }
}



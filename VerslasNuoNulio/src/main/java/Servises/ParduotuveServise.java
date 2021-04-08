package Servises;

import Entity.Parduotuve;
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
}

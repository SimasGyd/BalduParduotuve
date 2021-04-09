package Servises;

import Entity.Pardavimai;
import Repositories.PardavimaiRepository.PardavimaiRepository;

import java.util.List;

public class PardavimaiServise {
    private final PardavimaiRepository pardavimaiRepository;

    public PardavimaiServise(PardavimaiRepository pardavimaiRepository) {
        this.pardavimaiRepository = pardavimaiRepository;

    }
    public List<Pardavimai> findAllPardavimai() {
        return pardavimaiRepository.findAll();
    }

    public void findPrekeByIdUpdateKiekisPardavimai(long fragment, int kiekisFragment) {
        pardavimaiRepository.findPrekeByIdUpdateKiekisPardavimai(fragment, kiekisFragment);
    }
}


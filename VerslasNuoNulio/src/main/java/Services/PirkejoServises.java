package Services;

import repository.pirkejas.PirkejasRepository;
import repository.sandelys.SandelysRepository;

public class PirkejoServises {

    private final PirkejasRepository pirkejasRepository;

    public PirkejoServises(PirkejasRepository pirkejasRepository) {
        this.pirkejasRepository = pirkejasRepository;
    }
}

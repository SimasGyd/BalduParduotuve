package Servises;

import Entity.Parduotuve;
import Entity.Preke;
import Entity.Sandelys;
import Repositories.PrekeRepository.PrekeRepository;
import Utils.Output.OutputProducer;
import org.hibernate.criterion.Order;

import java.util.Comparator;
import java.util.List;

public class PrekeServise {

    private final PrekeRepository prekeRepository;
    private final SandelysServise sandelysServise;
    private final ParduotuveServise parduotuveServise;
    private final OutputProducer output;


    public PrekeServise(PrekeRepository prekeRepository, SandelysServise sandelysServise, ParduotuveServise parduotuveServise, OutputProducer output) {
        this.prekeRepository = prekeRepository;
        this.sandelysServise = sandelysServise;
        this.parduotuveServise = parduotuveServise;
        this.output = output;
    }


    public Preke saveNewPreke(String pavadinimas, String kategorija, String spalva, double kaina) {
        Preke preke = new Preke(pavadinimas, kategorija, spalva, kaina);
        prekeRepository.save(preke);
        return preke;
    }

    public void getAllPrekes() {
        List<Sandelys> sandelioPrekes = sandelysServise.findAllSandelys();
        List<Parduotuve> parduotuvePrekes = parduotuveServise.findAllParduotuve();
        for (Sandelys sandelys : sandelioPrekes) {
            for (Parduotuve parduotuve : parduotuvePrekes) {
                if (sandelys.getPreke().equals(parduotuve.getPreke())) {
                    sandelys.setKiekis(sandelys.getKiekis() + parduotuve.getKiekis());
                }
            }
        }
        sandelioPrekes.forEach(preke -> output.produce(preke.toString()));
    }

    public void getAllPrekesByColor() {
        Comparator<Preke> bySpalva = Comparator.comparing(Preke::getSpalva);
        List<Sandelys> sandelioPrekes = sandelysServise.findAllSandelys();
        List<Parduotuve> parduotuvePrekes = parduotuveServise.findAllParduotuve();
        for (Sandelys sandelys : sandelioPrekes) {
            for (Parduotuve parduotuve : parduotuvePrekes) {
                if (sandelys.getPreke().equals(parduotuve.getPreke())) {
                    sandelys.setKiekis(sandelys.getKiekis() + parduotuve.getKiekis());
                }
            }
        }
        sandelioPrekes.forEach(preke -> output.produce(preke.toString()));
    }
}



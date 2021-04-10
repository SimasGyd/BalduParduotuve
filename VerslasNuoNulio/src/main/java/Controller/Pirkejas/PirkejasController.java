package Controller.Pirkejas;

import Controller.Controller;
import Entity.Parduotuve;
import Entity.Sandelys;
import Servises.PardavimaiServise;
import Servises.ParduotuveServise;
import Servises.PrekeServise;
import Servises.SandelysServise;
import Utils.Input.InputReceiver;
import Utils.Output.OutputProducer;

import java.util.List;

public class PirkejasController implements Controller {


    private final PrekeServise prekeServise;
    private final SandelysServise sandelysServise;
    private final InputReceiver receiver;
    private final OutputProducer output;
    private final PardavimaiServise pardavimaiServise;
    private final ParduotuveServise parduotuveServise;

    public PirkejasController(PrekeServise prekeServise, SandelysServise sandelysServise, InputReceiver receiver, OutputProducer output, PardavimaiServise pardavimaiServise, ParduotuveServise parduotuveServise) {
        this.prekeServise = prekeServise;
        this.sandelysServise = sandelysServise;
        this.receiver = receiver;
        this.output = output;
        this.pardavimaiServise = pardavimaiServise;
        this.parduotuveServise = parduotuveServise;
    }

    @Override
    public void run() {
        output.produce("-- Pirkėjo Meniu --");
        pirkejoMeniu();
        receiveInputAndAct();
    }

    private void pirkejoMeniu() {
        output.produce("1 - Sąrašas visų prekių");
        output.produce("2 - Filtruoti prekes pagal spalvą");
        output.produce("3 - Filtruoti prekes pagal kainą");
        output.produce("4 - Pirkti prekę");
        output.produce("5 - Grįžti");
    }

    private void receiveInputAndAct() {
        String input = receiver.receiveLine().toUpperCase();
        switch (input) {
            case "1": {
                prekiuSarasas();
                break;
            }
            case "2": {
                prekiuSarasasBySpalva();
                break;
            }
            case "3": {
                prekiuFiltrasPagalKaina();
                break;
            }
            case "4": {
                pirktiPreke();
                break;
            }
            case "5": {
                return;
            }
            default: {
                output.produce("Neteisingas pasirinkimas");
                pirkejoMeniu();
            }
        }
        receiveInputAndAct();
    }

    private void listAllPrekes() {
        // sandelysServise.getsarasas();
    }

    private void prekiuFiltrasPagalKaina() {
    }

    private void pirktiPreke() {
        output.produce("Įveskite prekės ID :");
        long id = Integer.valueOf(receiver.receiveLine());
        output.produce("Įveskite kiekį :");
        int kiekis = Integer.valueOf(receiver.receiveLine());
        sandelysServise.findPrekeByIdUpdateKiekis(id, kiekis);
        pardavimaiServise.findPrekeByIdUpdateKiekisPardavimai(id, kiekis);
        output.produce("Prekė sėkmingai nupirkta!");
    }

    public void prekiuSarasas() {
        output.produce("==== Prekės Sąrašas ====");
        List<Sandelys> sandelioPrekes = sandelysServise.findAllSandelys();
        List<Parduotuve> parduotuvePrekes = parduotuveServise.findAllParduotuve();
        for (Sandelys sandelys : sandelioPrekes){
            for(Parduotuve parduotuve : parduotuvePrekes){
                if (sandelys.getPreke().equals(parduotuve.getPreke())){
                    sandelys.setKiekis(sandelys.getKiekis() + parduotuve.getKiekis());
                }
            }
        }
        sandelioPrekes.forEach(preke -> output.produce(preke.toString()));
        output.produce("========================");
    }

    public void prekiuSarasasBySpalva() {
        output.produce("==== Prekės Sandėlyje Surušiuota pagal spalvą ====");
        output.produce("==================================================");
    }
}


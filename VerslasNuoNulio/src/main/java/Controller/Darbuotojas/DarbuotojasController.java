package Controller.Darbuotojas;

import Controller.Controller;
import Entity.Sandelys;
import Servises.PardavimaiServise;
import Servises.ParduotuveServise;
import Servises.PrekeServise;
import Servises.SandelysServise;
import Utils.Input.InputReceiver;
import Utils.Output.OutputProducer;

import java.util.Collection;

public class DarbuotojasController implements Controller {

    private final PrekeServise prekeServise;
    private final ParduotuveServise parduotuveServise;
    private final SandelysServise sandelysServise;
    private final PardavimaiServise pardavimaiServise;
    private final InputReceiver receiver;
    private final OutputProducer output;


    public DarbuotojasController(PrekeServise prekeServise, ParduotuveServise parduotuveServise, SandelysServise sandelysServise, PardavimaiServise pardavimaiServise, InputReceiver receiver, OutputProducer output) {
        this.prekeServise = prekeServise;
        this.parduotuveServise = parduotuveServise;
        this.sandelysServise = sandelysServise;
        this.pardavimaiServise = pardavimaiServise;
        this.receiver = receiver;
        this.output = output;
    }

    @Override
    public void run() {
        output.produce("-- Darbuotojo Meniu --");
        darbuotojoMeniu();
        receiveInputAndAct();
    }

    private void darbuotojoMeniu() {

        output.produce("1 - Užsakyti naują prekę");
        output.produce("2 - Parduotuvės prekių likučiai");
        output.produce("3 - Sandėlio prekių likučiai");
        output.produce("4 - Pardavimų sąrašas");
        output.produce("5 - Prekės kurios eina į pabaigą");
        output.produce("6 - Užsakyti prekę iš sandėlio į parduotuvę");
        output.produce("7 - Grįžti");
    }

    private void receiveInputAndAct() {
        String input = receiver.receiveLine().toUpperCase();
        switch (input) {
            case "1": {

                sukurtiNaujaPreke();
                break;
            }
            case "2": {
                parduotuvesLikuciai();
                break;
            }
            case "3": {
                sandelioLikuciai();
                break;
            }
            case "4": {
                listAllPardavimai();
                break;
            }
            case "5": {
                prekesKuriasReikiaUzsakyti();
                break;
            }
            case "6": {
                uzsakytiPrekeIsSandelio();
                break;
            }
            case "7": {
                return;
            }
            default: {
                output.produce("Neteisingas pasirinkimas");
                darbuotojoMeniu();
            }
        }
        receiveInputAndAct();
    }

    public void sukurtiNaujaPreke() {
        output.produce("Įveskite prekės pavadinimą :");
        String pavadinimas = receiver.receiveLine();
        output.produce("Įveskite prekės kategoriją :");
        String kategorija = receiver.receiveLine();
        output.produce("Įveskite prekės spalvą :");
        String spalva = receiver.receiveLine();
        output.produce("Įveskite prekės kainą :");
        Double kaina = Double.valueOf(receiver.receiveLine());
        output.produce("Įveskite prekės kiekį :");
        int kiekis  = Integer.valueOf(receiver.receiveLine());
        sandelysServise.saveNewPrekeSand(kiekis, prekeServise.saveNewPreke(pavadinimas, kategorija, spalva, kaina));
        output.produce("Nauja prekė sėkmingai užsakyta!");
    }


    public void parduotuvesLikuciai() {
        output.produce("==== Prekės Parduotuvėje ====");
        parduotuveServise.findAllParduotuve().forEach(parduotuve -> output.produce(parduotuve.toString()));
        output.produce("=============================");
    }

    public void sandelioLikuciai() {
        output.produce("==== Prekės Sandėlyje ====");
        sandelysServise.findAllSandelys().forEach(sandelys -> output.produce(sandelys.toString()));
        output.produce("==========================");
    }

    private void listAllPardavimai() {
        output.produce("==== Visi Pardavimai ====");
        pardavimaiServise.findAllPardavimai().forEach(pardavimai -> output.produce(pardavimai.toString()));
        output.produce("=========================");
    }


    public void prekesKuriasReikiaUzsakyti() {
        output.produce("==== Rekomenduojama užsakyti šias prekes ====");
        sandelysServise.uzsakytiPrekes().forEach(sandelys -> output.produce(sandelys.toString()));
        output.produce("=============================================");
    }

    public void uzsakytiPrekeIsSandelio() {
        return;
    }
}

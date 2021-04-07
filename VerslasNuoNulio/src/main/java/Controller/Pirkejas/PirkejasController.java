package Controller.Pirkejas;

import Controller.Controller;
import Servises.PrekeServise;
import Utils.Input.InputReceiver;
import Utils.Output.OutputProducer;

public class PirkejasController implements Controller {


    private final PrekeServise prekeServise;
    private final InputReceiver receiver;
    private final OutputProducer output;

    public PirkejasController(PrekeServise prekeServise, InputReceiver receiver, OutputProducer output) {
        this.prekeServise = prekeServise;
        this.receiver = receiver;
        this.output = output;
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
                listAllPrekes();
                break;
            }
            case "2": {
                prekiuFiltrasPagalSpalva();
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
//    prekeServise.bandymas();
    }

    private void prekiuFiltrasPagalSpalva() {

    }

    private void prekiuFiltrasPagalKaina() {
    }

    private void pirktiPreke() {
        output.produce("Įveskite prekės ID :");
        int id = Integer.valueOf(receiver.receiveLine());
        output.produce("Įveskite kiekį :");
        int kiekis = Integer.valueOf(receiver.receiveLine());
    }
}


package Valdymas.Pirkejas;

import Services.DarbuotojoServises;
import Services.PirkejoServises;
import Util.Input.InputReciever;
import Util.Output.OutputReciever;
import Valdymas.Valdymas;

public class PirkejoValdymas implements Valdymas {
    private final DarbuotojoServises darbuotojoServises;
    private final PirkejoServises pirkejoServises;
    private final InputReciever receiver;
    private final OutputReciever output;

    public PirkejoValdymas(DarbuotojoServises darbuotojoServises, PirkejoServises pirkejoServises, InputReciever receiver, OutputReciever output) {
        this.darbuotojoServises = darbuotojoServises;
        this.pirkejoServises = pirkejoServises;
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
        return;
    }

    private void prekiuFiltrasPagalSpalva() {
        return;
    }

    private void prekiuFiltrasPagalKaina() {
        return;
    }

    private void pirktiPreke() {
        return; }
}


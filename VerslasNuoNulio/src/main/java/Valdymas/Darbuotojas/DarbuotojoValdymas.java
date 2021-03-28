package Valdymas.Darbuotojas;

import Services.DarbuotojoServises;
import Services.PirkejoServises;
import Util.Input.InputReciever;
import Util.Output.OutputReciever;
import Valdymas.Valdymas;

public class DarbuotojoValdymas implements Valdymas {
    private final DarbuotojoServises darbuotojoServises;
    private final PirkejoServises pirkejoServises;
    private final InputReciever receiver;
    private final OutputReciever output;

    public DarbuotojoValdymas(DarbuotojoServises darbuotojoServises, PirkejoServises pirkejoServises, InputReciever receiver, OutputReciever output) {
        this.darbuotojoServises = darbuotojoServises;
        this.pirkejoServises = pirkejoServises;
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
        output.produce("4 - Prekės kurios eina į pabaigą");
        output.produce("5 - Užsakyti prekę iš sandėlio į parduotuvę");
        output.produce("6 - Grįžti");
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
                prekesKuriasReikiaUzsakyti();
                break;
            }
            case "5": {
                uzsakytiPrekeIsSandelio();
                break;
            }
            case "6": {
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
        return;
    }

    public void parduotuvesLikuciai() {
        return;
    }

    public void sandelioLikuciai() {
        return;
    }

    public void prekesKuriasReikiaUzsakyti() {
        return;
    }

    public void uzsakytiPrekeIsSandelio() {
        return; }

}

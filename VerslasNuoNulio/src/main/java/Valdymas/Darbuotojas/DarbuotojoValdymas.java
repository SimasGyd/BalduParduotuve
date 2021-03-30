package Valdymas.Darbuotojas;

import Entity.Pardavimai;
import Entity.Parduotuve;
import Entity.Sandelys;
import Services.DarbuotojoServises;
import Services.PirkejoServises;
import Util.Input.InputReciever;
import Util.Output.OutputReciever;
import Valdymas.Valdymas;

import java.util.List;

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
                pardavimaiList();
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
        return;
    }

    public void parduotuvesLikuciai() {
        List<Parduotuve> prekiuLikutis = DarbuotojoServises.prekiuLikutisParduotuveje();
        System.out.println("Prekių likutis parduotuvėje :");
        for (Parduotuve parda : prekiuLikutis) {
            System.out.println(parda);
        }
    }

    public void sandelioLikuciai() {
        List<Sandelys> remainingPrekes = darbuotojoServises.prekiuLikutisSandelyje();
        System.out.println("Prekių likutis sandėlyje :");
        for (Sandelys sand : remainingPrekes) {
            System.out.println(sand);
        }
    }
    public void pardavimaiList(){
        List<Pardavimai> parduotosPrekes = darbuotojoServises.pardavimaiList();
        System.out.println("Parduotos prekių sąrašas :");
        for (Pardavimai pard : parduotosPrekes) {
            System.out.println(pard);
        }
    }


    public void prekesKuriasReikiaUzsakyti() {
        return;
    }

    public void uzsakytiPrekeIsSandelio() {
        return;
    }

}

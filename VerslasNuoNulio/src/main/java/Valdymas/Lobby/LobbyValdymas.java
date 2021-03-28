package Valdymas.Lobby;

import Util.Input.InputReciever;
import Util.Output.OutputReciever;
import Valdymas.Valdymas;

public class LobbyValdymas implements Valdymas {

    private final Valdymas darbuotojas;
    private final Valdymas pirkejas;
    private final InputReciever receiver;
    private final OutputReciever output;

    public LobbyValdymas(Valdymas darbuotojas, Valdymas pirkejas, InputReciever receiver, OutputReciever output) {
        this.darbuotojas = darbuotojas;
        this.pirkejas = pirkejas;
        this.receiver = receiver;
        this.output = output;

    }

    @Override
    public void run() {
        output.produce("-- Sveiki atvyke į BALDŲ PARDUOTUVĘ --");
        lobbyInstrukcija();
        receiveInputAndAct();
    }

    private void lobbyInstrukcija() {
        output.produce("1 - Pirkėjas");
        output.produce("2 - Darbuotojas");
        output.produce("3 - Baigti");
    }

    private void receiveInputAndAct() {
        String input = receiver.receiveLine().toUpperCase();
        switch (input) {
            case "1": {
                darbuotojas.run();
                break;
            }
            case "2": {
                pirkejas.run();
                break;
            }
            case "3": {
                return;
            }
            default: {
                output.produce("Neteisingas pasirinkimas");
                lobbyInstrukcija();
            }
        }
        receiveInputAndAct();
    }
}


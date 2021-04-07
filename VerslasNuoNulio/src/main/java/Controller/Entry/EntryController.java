package Controller.Entry;

import Controller.Controller;
import Utils.Input.InputReceiver;
import Utils.Output.OutputProducer;

public class EntryController implements Controller {

    private final Controller darbuotojasController;
    private final Controller pirkejasController;
    private final InputReceiver receiver;
    private final OutputProducer output;

    public EntryController(Controller darbuotojasController, Controller pirkejasController, InputReceiver receiver, OutputProducer output) {
        this.darbuotojasController = darbuotojasController;
        this.pirkejasController = pirkejasController;
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
                pirkejasController.run();
                break;
            }
            case "2": {
                darbuotojasController.run();
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

package Util.Input;

import java.util.Scanner;

public class DefaultInputReciever implements InputReciever{
    private final Scanner in = new Scanner(System.in);

    @Override
    public String receiveLine() {
        return in.nextLine();
    }
}

package run;

import network.Client;
import presenters.Presenter;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        new Presenter();
        /*Scanner scanner = new Scanner(System.in);
        try {
            Client client = new Client();
            System.out.println(client.getTextFromServer());
            client.writeMessage(scanner.nextLine());
        } catch (IOException exception) {
            exception.printStackTrace();
        }*/
    }
}

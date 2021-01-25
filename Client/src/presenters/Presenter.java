package presenters;

import models.ClientSend;
import network.Client;
import views.JFMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Presenter implements ActionListener {

    private JFMain jfMain;
    private Client client;

    public Presenter() throws IOException {
        jfMain = new JFMain(this);
        client = new Client();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Commands.valueOf(e.getActionCommand())) {
            case SEND_MESSAGE:
                sendMessage();
        }
    }

    private void sendMessage() {
        try {
            /*client.sendMessage(jfMain.getMessage());*/
            client.sendObject(new ClientSend(jfMain.getNickname(), jfMain.getIp(), jfMain.getMessage()));
            jfMain.clearMessage();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JFMain extends JFrame {

    private JPChat jpChat;

    public JFMain(ActionListener listener) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(500, 600));
        setLocationRelativeTo(this);
        setTitle("Just talk");

        jpChat = new JPChat(listener);
        add(jpChat);

        setVisible(true);
    }

    public String getMessage() {
        return jpChat.getMessage();
    }

    public void clearMessage() {
        jpChat.clearMessage();
    }
}

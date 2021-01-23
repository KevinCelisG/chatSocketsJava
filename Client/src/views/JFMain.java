package views;

import javax.swing.*;
import java.awt.*;

public class JFMain extends JFrame {

    private JPChat jpChat;

    public JFMain() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(500, 600));
        setLocationRelativeTo(this);
        setTitle("Just talk");

        jpChat = new JPChat();
        add(jpChat);

        setVisible(true);
    }
}

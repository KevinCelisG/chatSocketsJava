package views;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPChat extends JPanel {

    private JTextArea jTextArea;

    public JPChat() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Chat");
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        jTextArea = new JTextArea();
        jTextArea.setBorder(titledBorder);
        add(jTextArea);

        JButton jBSendMessage = new JButton("send message");
        add(jBSendMessage);
    }
}

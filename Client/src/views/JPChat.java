package views;

import presenters.Commands;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPChat extends JPanel {

    private JTextArea jTextArea;
    private JTextField jTFMessage;
    private JTextField jTFNick;
    private JTextField jTFIp;

    public JPChat(ActionListener listener) {
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setLayout(new BorderLayout());

        JPanel jPHeaderChat = new JPanel();
        jPHeaderChat.setPreferredSize(new Dimension(400, 100));

        jTFIp = getJTFCustom("Ip");
        jPHeaderChat.add(jTFIp);

        jTFNick = getJTFCustom("Nickname");
        jPHeaderChat.add(jTFNick);
        add(jPHeaderChat, BorderLayout.PAGE_START);

        jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        jTextArea.setMaximumSize(new Dimension(400, 300));
        add(new JScrollPane(jTextArea), BorderLayout.CENTER);

        JPanel jPFooterChat = new JPanel();
        GridLayout gridLayoutFooter = new GridLayout(2, 1);
        gridLayoutFooter.setVgap(10);
        jPFooterChat.setLayout(gridLayoutFooter);

        jTFMessage = getJTFCustom("Message");
        jPFooterChat.add(jTFMessage);

        JButton jBSendMessage = new JButton("Send message");
        jBSendMessage.addActionListener(listener);
        jBSendMessage.setActionCommand(Commands.SEND_MESSAGE.toString());
        jPFooterChat.add(jBSendMessage);
        add(jPFooterChat, BorderLayout.PAGE_END);
    }

    public String getMessage() {
        return jTFMessage.getText();
    }

    public void clearMessage() {
        jTFMessage.setText("");
    }

    private JTextField getJTFCustom(String text) {
        JTextField jTextField = new JTextField();
        jTextField.setBorder(getTitledBorder(text));
        jTextField.setPreferredSize(new Dimension(150, 50));
        return jTextField;
    }

    private TitledBorder getTitledBorder(String titled) {
        TitledBorder titledBorder = BorderFactory.createTitledBorder(titled);
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        return titledBorder;
    }
}

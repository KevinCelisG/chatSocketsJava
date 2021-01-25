package network;

import models.ClientSend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private final Socket socketClient;
    private static final int PORT = 8000;

    public Client() throws IOException {
        socketClient = new Socket(InetAddress.getLocalHost(), PORT);
    }

    public void sendObject(ClientSend clientSend) throws IOException {
        new ObjectOutputStream(socketClient.getOutputStream()).writeObject(clientSend);
    }

    public void sendMessage(String message) throws IOException {
        new DataOutputStream(socketClient.getOutputStream()).writeUTF(message);
    }

    public String getTextFromServer() throws IOException {
        return new DataInputStream(socketClient.getInputStream()).readUTF();
    }
}

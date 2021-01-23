package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private final ServerSocket serverSocket;
    private static final int PORT = 8000;

    public Server() throws IOException {
        serverSocket = new ServerSocket(PORT);
        Logger.getGlobal().log(Level.INFO, "servidor corriendo");
        startServer();
    }

    private void startServer() {
        Thread thread = new Thread(() -> {
            try {
                processData();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        thread.start();
    }

    private void processData() throws IOException {
        Socket connection = makeConnection();
        boolean check = true;
        String message;

        while (check) {
            if (!connection.isClosed()) {
                new DataOutputStream(connection.getOutputStream()).writeUTF("Write a word, if you want to exit to the program, just write salir");
                message = new DataInputStream(connection.getInputStream()).readUTF();
                if (message.equalsIgnoreCase("Salir")) {
                    check = false;
                } else {
                    System.out.println(message);
                }
                connection.close();
            } else {
                connection = makeConnection();
            }
        }
    }

    private Socket makeConnection() throws IOException {
        Logger.getGlobal().log(Level.INFO, "Esperando conexión");
        Socket connection = serverSocket.accept();
        Logger.getGlobal().log(Level.INFO, "Conexión establecida");
        return connection;
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

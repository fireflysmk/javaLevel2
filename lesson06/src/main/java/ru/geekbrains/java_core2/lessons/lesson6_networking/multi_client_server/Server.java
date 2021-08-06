package ru.geekbrains.java_core2.lessons.lesson6_networking.multi_client_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8089;

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server start!");
            while (true) {
                System.out.println("Waiting for connection......");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                new Handler(socket).handle();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

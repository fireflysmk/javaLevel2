package ru.geekbrains.java_core2.lessons.lesson6_networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class VerySimpleClient {
    private static final String HOST = "localhost";
    private static final int PORT = 8089;

    public static void main(String[] args) {

        try (Socket socket = new Socket(HOST, PORT);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String message = scanner.nextLine();
                out.writeUTF(message);
                Thread.sleep(200);
                message = in.readUTF();
                System.out.println("Received: " + message);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

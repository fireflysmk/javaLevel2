package ru.geekbrains.java_core2.lessons.lesson6_networking.multi_client_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Handler {
    private static int clientCounter = 0;



    private int clientNumber;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Thread handlerThread;
    private String inputMessage;
    private boolean isInputMessageExists;


    public Handler(Socket socket) {
        try {
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Handler created");
            this.clientNumber = ++clientCounter;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handle() {
        handlerThread = new Thread(() -> {
            String s;
            while (!Thread.currentThread().isInterrupted() && socket.isConnected()) {
                try {
                    inputMessage = in.readUTF();
                    System.out.printf("Client #%d: %s\n", this.clientNumber, inputMessage);

                    isInputMessageExists = true;

                    String outputMessage = "Client" + this.clientNumber + " wrote: " + inputMessage;
                    out.writeUTF(outputMessage);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        handlerThread.start();
    }


    public Thread getHandlerThread() {
        return handlerThread;
    }

    public String getInputMessage(){
        return inputMessage;
    }

    public boolean getIsInputMessageExists(){
        return isInputMessageExists;
    }

    public void setFalseInputMessageExists() {
        this.isInputMessageExists = false;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public int getClientNumber() {
        return clientNumber;
    }
}

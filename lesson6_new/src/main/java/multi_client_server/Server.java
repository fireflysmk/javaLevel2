package multi_client_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final int PORT = 8089;

    public List<Handler> handlerList = new ArrayList<>();

    Thread notifyThread = new Thread(() -> {

        String messageForNotifyAll;
        String client;
        while (true) {
            if (handlerList != null && handlerList.size() > 0) {
               // System.out.println("handlerList is not null");
                for (Handler h : handlerList) {
                    if (h.getIsInputMessageExists()) {
                      //  System.out.println("getIsInputMessageExists TRUE");
                        messageForNotifyAll = h.getInputMessage();
                        client = "Client" + h.getClientNumber();

                        for (Handler h1 : handlerList) {
                            try {
                                h1.getOut().writeUTF("Message from " + client + "  :" +  messageForNotifyAll);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        h.setFalseInputMessageExists();
                    }
                }
            }
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    });


    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server start!");
            notifyThread.start();
            while (true) {
                System.out.println("Waiting for connection......");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                Handler handler = new Handler(socket);
                handler.handle();

                handlerList.add(handler);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

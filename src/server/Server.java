package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Started");
            Socket client = serverSocket.accept();
            System.out.println("Connected");
            final Scanner in = new Scanner(client.getInputStream());
            final PrintWriter out = new PrintWriter(client.getOutputStream());
//            String s = "sf";

            new Thread(() -> {
                while (true) {
                    if (in.hasNext()) {
                        out.println("Echo: " + in.nextLine());
                        out.flush();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

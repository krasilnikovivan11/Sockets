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
            Scanner in = new Scanner(client.getInputStream());
//            PrintWriter out = new PrintWriter(client.getOutputStream());
//            Scanner scanner = new Scanner(System.in);

            while(true) {
                if (in.hasNext()) {
                    System.out.println("Echo: " + in.nextLine());
                }
//                out.println(scanner.nextLine());
//                out.flush();
//                System.out.println(in.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

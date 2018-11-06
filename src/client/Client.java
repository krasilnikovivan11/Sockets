package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 8189);
            final Scanner in = new Scanner(client.getInputStream());
            final PrintWriter out = new PrintWriter(client.getOutputStream());
            final Scanner scanner = new Scanner(System.in);

            new Thread(() -> {
                while (true) {
                    if (scanner.hasNext()) {
                        String s = scanner.nextLine();
                        out.println(s);
                        out.flush();
                    }
                }
            }).start();

            new Thread(() -> {
                while (true) {
                    if (in.hasNext()) {
                        String s = in.nextLine();
                        System.out.println(s);
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

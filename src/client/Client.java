package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost",8189);
//            Scanner in = new Scanner(client.getInputStream());
            PrintWriter out = new PrintWriter(client.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
//                System.out.println(scanner.nextLine());
                out.println(scanner.nextLine());
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

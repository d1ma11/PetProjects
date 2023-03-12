package chatApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        final Socket clientSocket;
        final BufferedReader in;
        final PrintWriter out;
        final Scanner scanner = new Scanner(System.in);

        try (final ServerSocket serverSocket = new ServerSocket(5000, 1)) {
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread sender = new Thread(new Runnable() {
                String msg;

                @Override
                public void run() {
                    while (true) {
                        msg = scanner.nextLine();
                        out.println(msg);
                        out.flush();
                    }
                }
            });
            sender.start();
            Thread receive = new Thread(new Runnable() {
                String msg;

                @Override
                public void run() {
                    try (out; clientSocket; serverSocket) {
                        msg = in.readLine();

                        while (msg != null) {
                            System.out.println("Client :" + msg);
                            msg = in.readLine();
                        }

                        System.out.println("Client disconnected");

                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            });
            receive.start();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

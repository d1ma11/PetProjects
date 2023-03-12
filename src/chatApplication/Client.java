package chatApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final BufferedReader in;
        final PrintWriter out;
        final Scanner scanner = new Scanner(System.in);

        try (final Socket clientSocket = new Socket("127.0.0.1", 5000)) {
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

            Thread receiver = new Thread(new Runnable() {
                String msg;

                @Override
                public void run() {
                    try (clientSocket; out) {
                        msg = in.readLine();
                        while (msg != null) {
                            System.out.println("Server : " + msg);
                            msg = in.readLine();
                        }
                        System.out.println("Server out of service");
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            });
            receiver.start();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

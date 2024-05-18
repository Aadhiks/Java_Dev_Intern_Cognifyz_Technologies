import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to the Chat Server");

            Scanner serverInput = new Scanner(socket.getInputStream());
            PrintWriter clientOutput = new PrintWriter(socket.getOutputStream(), true);

            Scanner userInput = new Scanner(System.in);

            // Thread to handle server messages
            Thread serverThread = new Thread(() -> {
                while (true) {
                    if (serverInput.hasNextLine()) {
                        String message = serverInput.nextLine();
                        System.out.println("Server: " + message);
                    }
                }
            });
            serverThread.start();

            // Thread to handle user input and send messages to the server
            Thread clientThread = new Thread(() -> {
                while (true) {
                    if (userInput.hasNextLine()) {
                        String message = userInput.nextLine();
                        clientOutput.println(message);
                    }
                }
            });
            clientThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

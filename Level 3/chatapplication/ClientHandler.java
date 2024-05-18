import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter writer;

    public ClientHandler(Socket clientSocket, PrintWriter writer) {
        this.clientSocket = clientSocket;
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(clientSocket.getInputStream());

            while (true) {
                if (scanner.hasNextLine()) {
                    String clientMessage = scanner.nextLine();
                    ChatServer.broadcastMessage(clientMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

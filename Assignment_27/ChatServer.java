import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat server started on port " + PORT + ". Waiting for client...");

            try (Socket socket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {

                System.out.println("Client connected: " + socket.getInetAddress());
                System.out.println("Type 'bye' to end the chat.");

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Client: " + clientMessage);
                    if (clientMessage.equalsIgnoreCase("bye")) {
                        break;
                    }

                    System.out.print("Server: ");
                    String reply = keyboard.readLine();
                    out.println(reply);
                    if (reply == null || reply.equalsIgnoreCase("bye")) {
                        break;
                    }
                }
                System.out.println("Chat ended");
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}

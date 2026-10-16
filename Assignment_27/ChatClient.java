import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    static final String HOST = "localhost";
    static final int PORT = 5000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to chat server at " + HOST + ":" + PORT);
            System.out.println("Type 'bye' to end the chat.");

            while (true) {
                System.out.print("Client: ");
                String message = keyboard.readLine();
                out.println(message);
                if (message == null || message.equalsIgnoreCase("bye")) {
                    break;
                }

                String reply = in.readLine();
                if (reply == null) {
                    break;
                }
                System.out.println("Server: " + reply);
                if (reply.equalsIgnoreCase("bye")) {
                    break;
                }
            }
            System.out.println("Chat ended");
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    static final String HOST = "localhost";
    static final int PORT = 6000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to echo server. Type 'exit' to quit.");

            while (true) {
                System.out.print("Enter message: ");
                String message = keyboard.readLine();
                if (message == null) {
                    break;
                }
                out.println(message);
                System.out.println("Server replied -> " + in.readLine());
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}

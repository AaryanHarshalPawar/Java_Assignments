import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Registry registry = LocateRegistry.getRegistry("localhost", CalculatorServer.PORT);
            // lookup() returns the stub: a local proxy that forwards calls to the server
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");
            System.out.println("Connected to Calculator service. Stub class: " + calculator.getClass().getName());

            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();

            System.out.println("Addition       : " + calculator.add(a, b));
            System.out.println("Subtraction    : " + calculator.subtract(a, b));
            System.out.println("Multiplication : " + calculator.multiply(a, b));
            try {
                System.out.println("Division       : " + calculator.divide(a, b));
            } catch (RemoteException e) {
                Throwable cause = e.getCause() != null ? e.getCause() : e;
                System.out.println("Division       : Error - " + cause.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}

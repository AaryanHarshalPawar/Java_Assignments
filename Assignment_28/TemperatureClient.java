import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class TemperatureClient {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Registry registry = LocateRegistry.getRegistry("localhost", TemperatureServer.PORT);
            TemperatureConverter converter = (TemperatureConverter) registry.lookup("TemperatureService");
            System.out.println("Connected to Temperature service. Stub class: " + converter.getClass().getName());

            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            System.out.print("Enter temperature: ");
            double value = scanner.nextDouble();

            if (choice == 1) {
                System.out.printf("%.2f C = %.2f F%n", value, converter.celsiusToFahrenheit(value));
            } else if (choice == 2) {
                System.out.printf("%.2f F = %.2f C%n", value, converter.fahrenheitToCelsius(value));
            } else {
                System.out.println("Invalid choice");
            }
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}

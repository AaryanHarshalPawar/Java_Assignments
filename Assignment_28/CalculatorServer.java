import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    static final int PORT = 1099;

    public static void main(String[] args) {
        try {
            Calculator calculator = new CalculatorImpl();
            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.rebind("CalculatorService", calculator);
            System.out.println("Calculator RMI server is running on port " + PORT);
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}

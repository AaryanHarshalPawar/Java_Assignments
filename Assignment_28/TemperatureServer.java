import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TemperatureServer {
    static final int PORT = 1100;

    public static void main(String[] args) {
        try {
            TemperatureConverter converter = new TemperatureConverterImpl();
            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.rebind("TemperatureService", converter);
            System.out.println("Temperature RMI server is running on port " + PORT);
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}

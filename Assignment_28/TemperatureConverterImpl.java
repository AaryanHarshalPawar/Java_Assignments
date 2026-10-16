import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TemperatureConverterImpl extends UnicastRemoteObject implements TemperatureConverter {
    private static final long serialVersionUID = 1L;

    protected TemperatureConverterImpl() throws RemoteException {
        super();
    }

    @Override
    public double celsiusToFahrenheit(double celsius) throws RemoteException {
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Converted " + celsius + " C to " + fahrenheit + " F");
        return fahrenheit;
    }

    @Override
    public double fahrenheitToCelsius(double fahrenheit) throws RemoteException {
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println("Converted " + fahrenheit + " F to " + celsius + " C");
        return celsius;
    }
}

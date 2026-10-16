import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Server-side object. The RMI runtime receives each remote call (the skeleton's job)
// and dispatches it to these methods.
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    private static final long serialVersionUID = 1L;

    protected CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        System.out.println("Request received: add(" + a + ", " + b + ")");
        return a + b;
    }

    @Override
    public double subtract(double a, double b) throws RemoteException {
        System.out.println("Request received: subtract(" + a + ", " + b + ")");
        return a - b;
    }

    @Override
    public double multiply(double a, double b) throws RemoteException {
        System.out.println("Request received: multiply(" + a + ", " + b + ")");
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws RemoteException {
        System.out.println("Request received: divide(" + a + ", " + b + ")");
        if (b == 0) {
            throw new RemoteException("Division by zero is not allowed");
        }
        return a / b;
    }
}

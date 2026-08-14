package Assignment_6;

public class Vehicle {
    String brand = "Honda";
    String model = "City VX";
    int year = 2023;
    double price = 1250000.0;

    interface VehicleAction {
        void perform();
    }

    class VehicleDetails {
        void display() {
            System.out.println("Vehicle Details");
            System.out.println("---------------");
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
            System.out.println("Price: Rs. " + price);
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();

        Vehicle.VehicleDetails details = vehicle.new VehicleDetails();
        details.display();

        System.out.println();

        VehicleAction startEngine = new VehicleAction() {
            public void perform() {
                System.out.println("Engine started successfully.");
            }
        };

        VehicleAction applyBrake = new VehicleAction() {
            public void perform() {
                System.out.println("Brakes applied. Vehicle stopped.");
            }
        };

        startEngine.perform();
        applyBrake.perform();
    }
}

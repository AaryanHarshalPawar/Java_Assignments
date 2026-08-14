package Assignment_8;

public class VehicleInsurance {
    static class VehicleInfo {
        String vehicleNumber;
        String ownerName;
        String vehicleType;
        double vehicleValue;

        VehicleInfo(String vehicleNumber, String ownerName, String vehicleType, double vehicleValue) {
            this.vehicleNumber = vehicleNumber;
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
            this.vehicleValue = vehicleValue;
        }

        void display() {
            System.out.println("Vehicle Number: " + vehicleNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Vehicle Value: Rs. " + vehicleValue);
        }
    }

    static class CarInsurance extends VehicleInfo {
        String policyNumber;
        int policyYears;

        CarInsurance(String vehicleNumber, String ownerName, double vehicleValue, String policyNumber, int policyYears) {
            super(vehicleNumber, ownerName, "Car", vehicleValue);
            this.policyNumber = policyNumber;
            this.policyYears = policyYears;
        }

        void display() {
            System.out.println("Car Insurance Policy");
            System.out.println("--------------------");
            super.display();
            System.out.println("Policy Number: " + policyNumber);
            System.out.println("Policy Duration: " + policyYears + " years");
            System.out.println("Premium Amount: Rs. " + (super.vehicleValue * 0.03));
        }
    }

    static class BikeInsurance extends VehicleInfo {
        String policyNumber;
        int policyYears;

        BikeInsurance(String vehicleNumber, String ownerName, double vehicleValue, String policyNumber, int policyYears) {
            super(vehicleNumber, ownerName, "Bike", vehicleValue);
            this.policyNumber = policyNumber;
            this.policyYears = policyYears;
        }

        void display() {
            System.out.println("Bike Insurance Policy");
            System.out.println("---------------------");
            super.display();
            System.out.println("Policy Number: " + policyNumber);
            System.out.println("Policy Duration: " + policyYears + " years");
            System.out.println("Premium Amount: Rs. " + (super.vehicleValue * 0.02));
        }
    }

    public static void main(String[] args) {
        CarInsurance car = new CarInsurance("MH12AB1234", "Harshal Pawar", 1250000.0, "POL-CAR-7781", 3);
        BikeInsurance bike = new BikeInsurance("MH14XY5678", "Aaryan Pawar", 95000.0, "POL-BIK-4432", 2);

        car.display();
        System.out.println();
        bike.display();
    }
}

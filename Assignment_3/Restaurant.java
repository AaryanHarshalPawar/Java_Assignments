package Assignment_3;

public class Restaurant {
    static int totalOrders = 0;
    static double totalRevenue = 0.0;

    double calculateBill(double foodAmount) {
        totalOrders++;
        double serviceCharge = foodAmount * 0.10;
        double gst = (foodAmount + serviceCharge) * 0.05;
        double total = foodAmount + serviceCharge + gst;
        System.out.println("Dine-In Order");
        System.out.println("Food Amount: Rs. " + foodAmount);
        System.out.println("Service Charge (10%): Rs. " + serviceCharge);
        System.out.println("GST (5%): Rs. " + gst);
        System.out.println("Total Bill: Rs. " + total);
        totalRevenue = totalRevenue + total;
        return total;
    }

    double calculateBill(double foodAmount, boolean packingRequired) {
        totalOrders++;
        double packingCharge = 0.0;
        if (packingRequired) {
            packingCharge = 20.0;
        }
        double gst = (foodAmount + packingCharge) * 0.05;
        double total = foodAmount + packingCharge + gst;
        System.out.println("Takeaway Order");
        System.out.println("Food Amount: Rs. " + foodAmount);
        System.out.println("Packing Charge: Rs. " + packingCharge);
        System.out.println("GST (5%): Rs. " + gst);
        System.out.println("Total Bill: Rs. " + total);
        totalRevenue = totalRevenue + total;
        return total;
    }

    double calculateBill(double foodAmount, double distanceInKm) {
        totalOrders++;
        double deliveryCharge = distanceInKm * 10.0;
        double gst = (foodAmount + deliveryCharge) * 0.05;
        double total = foodAmount + deliveryCharge + gst;
        System.out.println("Delivery Order");
        System.out.println("Food Amount: Rs. " + foodAmount);
        System.out.println("Distance: " + distanceInKm + " km");
        System.out.println("Delivery Charge: Rs. " + deliveryCharge);
        System.out.println("GST (5%): Rs. " + gst);
        System.out.println("Total Bill: Rs. " + total);
        totalRevenue = totalRevenue + total;
        return total;
    }

    static void displaySummary() {
        System.out.println("Total Orders Processed: " + totalOrders);
        System.out.println("Total Revenue: Rs. " + totalRevenue);
    }

    public static void main(String[] args) {
        Restaurant r = new Restaurant();

        r.calculateBill(500.0);
        System.out.println();

        r.calculateBill(300.0, true);
        System.out.println();

        r.calculateBill(450.0, 6.5);
        System.out.println();

        displaySummary();
    }

}

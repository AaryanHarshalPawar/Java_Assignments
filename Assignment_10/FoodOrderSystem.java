package Assignment_10;

public class FoodOrderSystem {
    static abstract class FoodOrder {
        int orderId;
        String itemName;
        int quantity;
        double pricePerItem;

        FoodOrder(int orderId, String itemName, int quantity, double pricePerItem) {
            this.orderId = orderId;
            this.itemName = itemName;
            this.quantity = quantity;
            this.pricePerItem = pricePerItem;
        }

        abstract void calculateBill();

        void displayOrder() {
            System.out.println("Order ID: " + orderId);
            System.out.println("Item: " + itemName);
            System.out.println("Quantity: " + quantity);
            System.out.println("Price per Item: Rs. " + pricePerItem);
        }
    }

    static class DineInOrder extends FoodOrder {
        int tableNumber;

        DineInOrder(int orderId, String itemName, int quantity, double pricePerItem, int tableNumber) {
            super(orderId, itemName, quantity, pricePerItem);
            this.tableNumber = tableNumber;
        }

        void calculateBill() {
            double foodAmount = quantity * pricePerItem;
            double serviceCharge = foodAmount * 0.10;
            double totalBill = foodAmount + serviceCharge;

            System.out.println("Dine-In Order");
            System.out.println("-------------");
            displayOrder();
            System.out.println("Table Number: " + tableNumber);
            System.out.println("Food Amount: Rs. " + foodAmount);
            System.out.println("Service Charge (10%): Rs. " + serviceCharge);
            System.out.println("Total Bill: Rs. " + totalBill);
        }
    }

    static class TakeAwayOrder extends FoodOrder {
        double packingCharge;

        TakeAwayOrder(int orderId, String itemName, int quantity, double pricePerItem, double packingCharge) {
            super(orderId, itemName, quantity, pricePerItem);
            this.packingCharge = packingCharge;
        }

        void calculateBill() {
            double foodAmount = quantity * pricePerItem;
            double totalBill = foodAmount + packingCharge;

            System.out.println("Take Away Order");
            System.out.println("---------------");
            displayOrder();
            System.out.println("Food Amount: Rs. " + foodAmount);
            System.out.println("Packing Charge: Rs. " + packingCharge);
            System.out.println("Total Bill: Rs. " + totalBill);
        }
    }

    public static void main(String[] args) {
        FoodOrder dineIn = new DineInOrder(5001, "Veg Biryani", 3, 220.0, 12);
        FoodOrder takeAway = new TakeAwayOrder(5002, "Butter Naan", 6, 45.0, 25.0);

        dineIn.calculateBill();
        System.out.println();
        takeAway.calculateBill();
    }
}

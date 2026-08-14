package Assignment_6;

public class FoodDelivery {
    String customerName = "Aaryan Pawar";
    String restaurantName = "Spice Garden";

    interface DeliveryStatus {
        void update();
    }

    class OrderDetails {
        int orderId;
        String itemName;
        int quantity;
        double pricePerItem;

        OrderDetails(int orderId, String itemName, int quantity, double pricePerItem) {
            this.orderId = orderId;
            this.itemName = itemName;
            this.quantity = quantity;
            this.pricePerItem = pricePerItem;
        }

        void display() {
            System.out.println("Order Details");
            System.out.println("-------------");
            System.out.println("Customer: " + customerName);
            System.out.println("Restaurant: " + restaurantName);
            System.out.println("Order ID: " + orderId);
            System.out.println("Item: " + itemName);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Amount: Rs. " + (quantity * pricePerItem));
        }
    }

    public static void main(String[] args) {
        FoodDelivery delivery = new FoodDelivery();

        FoodDelivery.OrderDetails order = delivery.new OrderDetails(2045, "Paneer Butter Masala", 2, 280.0);
        order.display();

        System.out.println();
        System.out.println("Delivery Status Updates");
        System.out.println("-----------------------");

        DeliveryStatus orderConfirmed = new DeliveryStatus() {
            public void update() {
                System.out.println("Your order has been confirmed by the restaurant.");
            }
        };

        DeliveryStatus outForDelivery = new DeliveryStatus() {
            public void update() {
                System.out.println("Your order is out for delivery.");
            }
        };

        DeliveryStatus orderDelivered = new DeliveryStatus() {
            public void update() {
                System.out.println("Your order has been delivered. Enjoy your meal.");
            }
        };

        orderConfirmed.update();
        outForDelivery.update();
        orderDelivered.update();
    }
}

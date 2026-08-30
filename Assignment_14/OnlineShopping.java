import java.util.Scanner;

public class OnlineShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String productName = "Wireless Mouse";
        double pricePerUnit = 850.0;
        int stockAvailable = 10;

        System.out.println("Online Shopping");
        System.out.println("---------------");
        System.out.println("Product: " + productName);
        System.out.println("Price per unit: Rs. " + pricePerUnit);
        System.out.print("Enter quantity: ");

        try {
            int quantity = Integer.parseInt(sc.nextLine());

            try {
                if (quantity <= 0) {
                    throw new IllegalArgumentException("Quantity must be greater than zero. You entered: " + quantity);
                }
                if (quantity > stockAvailable) {
                    throw new IllegalStateException("Only " + stockAvailable + " units are in stock.");
                }

                double totalAmount = quantity * pricePerUnit;
                System.out.println("Quantity: " + quantity);
                System.out.println("Total Amount: Rs. " + totalAmount);
                System.out.println("Order placed successfully.");
            } catch (IllegalStateException e) {
                System.out.println("Stock Error: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("Input Error: Please enter a valid whole number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Quantity Error: " + e.getMessage());
        }

        sc.close();
    }
}

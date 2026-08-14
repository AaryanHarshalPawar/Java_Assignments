   package Assignment_7;
public class ECommerceSystem {
    interface Discountable {
        double applyDiscount();
    }

    static class Product {
        int productId;
        String productName;
        double price;

        Product(int productId, String productName, double price) {
            this.productId = productId;
            this.productName = productName;
            this.price = price;
        }

        void display() {
            System.out.println("Product ID: " + productId);
            System.out.println("Name: " + productName);
            System.out.println("Price: Rs. " + price);
        }
    }

    static class ElectronicProduct extends Product implements Discountable {
        int warrantyMonths;

        ElectronicProduct(int productId, String productName, double price, int warrantyMonths) {
            super(productId, productName, price);
            this.warrantyMonths = warrantyMonths;
        }

        public double applyDiscount() {
            return price - (price * 0.10);
        }

        void display() {
            System.out.println("Category: Electronics");
            super.display();
            System.out.println("Warranty: " + warrantyMonths + " months");
            System.out.println("Price after 10% discount: Rs. " + applyDiscount());
        }
    }

    static class ClothingProduct extends Product implements Discountable {
        String size;

        ClothingProduct(int productId, String productName, double price, String size) {
            super(productId, productName, price);
            this.size = size;
        }

        public double applyDiscount() {
            return price - (price * 0.20);
        }

        void display() {
            System.out.println("Category: Clothing");
            super.display();
            System.out.println("Size: " + size);
            System.out.println("Price after 20% discount: Rs. " + applyDiscount());
        }
    }

    static class GroceryProduct extends Product implements Discountable {
        String expiryDate;

        GroceryProduct(int productId, String productName, double price, String expiryDate) {
            super(productId, productName, price);
            this.expiryDate = expiryDate;
        }

        public double applyDiscount() {
            return price - (price * 0.05);
        }

        void display() {
            System.out.println("Category: Grocery");
            super.display();
            System.out.println("Expiry Date: " + expiryDate);
            System.out.println("Price after 5% discount: Rs. " + applyDiscount());
        }
    }

    public static void main(String[] args) {
        ElectronicProduct laptop = new ElectronicProduct(101, "Dell Laptop", 55000.0, 24);
        ClothingProduct shirt = new ClothingProduct(202, "Cotton Shirt", 1500.0, "Medium");
        GroceryProduct rice = new GroceryProduct(303, "Basmati Rice 5kg", 650.0, "12-08-2027");

        System.out.println("E-Commerce Product System");
        System.out.println("=========================");

        laptop.display();
        System.out.println();
        shirt.display();
        System.out.println();
        rice.display();
    }
}

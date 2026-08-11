package Assignment_2;

public class MobilePhone {
    String brand;
    String model;
    double price;
 
    MobilePhone() {
        brand = "Unknown";
        model = "Unknown";
        price = 0.0;
    }
 
    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
 
    MobilePhone(MobilePhone m) {
        this.brand = m.brand;
        this.model = m.model;
        this.price = m.price;
    }
 
    void display() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Price: Rs. " + price);
    }
 
    public static void main(String[] args) {
        MobilePhone m1 = new MobilePhone();
        MobilePhone m2 = new MobilePhone("Samsung", "Galaxy S24", 79999.0);
        MobilePhone m3 = new MobilePhone(m2);
 
        System.out.println("Mobile record using default constructor:");
        m1.display();
 
        System.out.println("Mobile record using parameterized constructor:");
        m2.display();
 
        System.out.println("Duplicate mobile record using copy constructor:");
        m3.display();
    }
}

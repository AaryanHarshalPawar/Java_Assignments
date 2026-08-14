package Assignment_7;

public class ShapeApplication {
    static class Shape {
        String shapeName;

        Shape(String shapeName) {
            this.shapeName = shapeName;
        }

        double calculateArea() {
            return 0.0;
        }

        void display() {
            System.out.println(shapeName + " Area: " + calculateArea());
        }
    }

    static class Circle extends Shape {
        double radius;

        Circle(double radius) {
            super("Circle");
            this.radius = radius;
        }

        double calculateArea() {
            return 3.14159 * radius * radius;
        }
    }

    static class Rectangle extends Shape {
        double length;
        double breadth;

        Rectangle(double length, double breadth) {
            super("Rectangle");
            this.length = length;
            this.breadth = breadth;
        }

        double calculateArea() {
            return length * breadth;
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(7.0);
        Rectangle rectangle = new Rectangle(12.0, 5.0);

        System.out.println("Shape Area Calculation");
        System.out.println("----------------------");

        System.out.println("Circle radius: " + circle.radius);
        circle.display();

        System.out.println("Rectangle length: " + rectangle.length + ", breadth: " + rectangle.breadth);
        rectangle.display();
    }
}

package Assignment_3;

public class Calculator {
    static int calculationCount = 0;

    int add(int a, int b) {
        calculationCount++;
        return a + b;
    }

    double add(double a, double b) {
        calculationCount++;
        return a + b;
    }

    int add(int a, int b, int c) {
        calculationCount++;
        return a + b + c;
    }

    double add(double a, double b, double c) {
        calculationCount++;
        return a + b + c;
    }

    static void displayCount() {
        System.out.println("Total calculations performed: " + calculationCount);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Addition of two integers: " + calc.add(25, 15));
        System.out.println("Addition of two decimals: " + calc.add(12.5, 7.25));
        System.out.println("Addition of three integers: " + calc.add(10, 20, 30));
        System.out.println("Addition of three decimals: " + calc.add(5.5, 4.25, 3.75));

        displayCount();
    }
}

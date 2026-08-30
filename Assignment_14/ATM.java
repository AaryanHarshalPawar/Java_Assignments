import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 50000.0;

        System.out.println("ATM Withdrawal");
        System.out.println("--------------");
        System.out.println("Available Balance: Rs. " + balance);
        System.out.print("Enter withdrawal amount: ");

        try {
            double withdrawalAmount = Double.parseDouble(sc.nextLine());

            try {
                if (withdrawalAmount <= 0) {
                    throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
                }
                if (withdrawalAmount % 100 != 0) {
                    throw new ArithmeticException("Amount must be a multiple of 100.");
                }
                if (withdrawalAmount > balance) {
                    throw new IllegalStateException("Insufficient balance. Available: Rs. " + balance);
                }

                balance = balance - withdrawalAmount;
                System.out.println("Rs. " + withdrawalAmount + " withdrawn successfully.");
                System.out.println("Remaining Balance: Rs. " + balance);
            } catch (ArithmeticException e) {
                System.out.println("Denomination Error: " + e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println("Balance Error: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("Input Error: Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println("Amount Error: " + e.getMessage());
        }

        System.out.println("Thank you for using the ATM.");
        sc.close();
    }
}

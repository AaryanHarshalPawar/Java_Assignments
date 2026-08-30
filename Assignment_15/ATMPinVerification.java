import java.util.Scanner;

public class ATMPinVerification {
    static void verifyPin(int enteredPin) throws Exception {
        int correctPin = 4321;
        try {
            if (enteredPin != correctPin) {
                throw new Exception("Invalid PIN entered. Access denied.");
            }
            System.out.println("PIN verified successfully. Account unlocked.");
        } finally {
            System.out.println("PIN verification process completed.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("ATM PIN Verification");
        System.out.println("--------------------");
        System.out.print("Enter your 4-digit PIN: ");

        try {
            int enteredPin = Integer.parseInt(sc.nextLine());
            verifyPin(enteredPin);
        } catch (NumberFormatException e) {
            System.out.println("Error: PIN must contain digits only.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

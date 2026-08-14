package Assignment_10;

public class PaymentSystem {
    static abstract class Payment {
        String payerName;
        double amount;

        Payment(String payerName, double amount) {
            this.payerName = payerName;
            this.amount = amount;
        }

        abstract void processPayment();

        void displayPayer() {
            System.out.println("Payer Name: " + payerName);
            System.out.println("Amount: Rs. " + amount);
        }
    }

    static class CreditCardPayment extends Payment {
        String cardNumber;
        String bankName;

        CreditCardPayment(String payerName, double amount, String cardNumber, String bankName) {
            super(payerName, amount);
            this.cardNumber = cardNumber;
            this.bankName = bankName;
        }

        void processPayment() {
            System.out.println("Credit Card Payment");
            System.out.println("-------------------");
            displayPayer();
            System.out.println("Card Number: " + cardNumber);
            System.out.println("Bank: " + bankName);
            System.out.println("Processing Fee: Rs. " + (amount * 0.02));
            System.out.println("Total Paid: Rs. " + (amount + (amount * 0.02)));
            System.out.println("Payment completed through Credit Card.");
        }
    }

    static class UpiPayment extends Payment {
        String upiId;

        UpiPayment(String payerName, double amount, String upiId) {
            super(payerName, amount);
            this.upiId = upiId;
        }

        void processPayment() {
            System.out.println("UPI Payment");
            System.out.println("-----------");
            displayPayer();
            System.out.println("UPI ID: " + upiId);
            System.out.println("Processing Fee: Rs. 0.0");
            System.out.println("Total Paid: Rs. " + amount);
            System.out.println("Payment completed through UPI.");
        }
    }

    public static void main(String[] args) {
        Payment cardPayment = new CreditCardPayment("Aaryan Pawar", 15000.0, "4521XXXXXXXX8890", "HDFC Bank");
        Payment upiPayment = new UpiPayment("Aaryan Pawar", 2500.0, "harshal@okaxis");

        cardPayment.processPayment();
        System.out.println();
        upiPayment.processPayment();
    }
}

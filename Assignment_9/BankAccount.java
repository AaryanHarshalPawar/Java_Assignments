package Assignment_9;

public class BankAccount {
    static class Account {
        final String accountNumber;
        String accountHolder;
        double balance;

        Account(String accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        void deposit(double amount) {
            balance = balance + amount;
            System.out.println("Amount deposited: Rs. " + amount);
        }

        void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Insufficient balance for withdrawal of Rs. " + amount);
            } else {
                balance = balance - amount;
                System.out.println("Amount withdrawn: Rs. " + amount);
            }
        }

        void display() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Balance: Rs. " + balance);
        }
    }

    public static void main(String[] args) {
        Account account = new Account("SBI0001234567", "Aaryan Pawar", 25000.0);

        System.out.println("Bank Account Details");
        System.out.println("--------------------");
        account.display();

        System.out.println();
        account.deposit(10000.0);
        account.withdraw(5000.0);
        account.withdraw(80000.0);

        System.out.println();
        System.out.println("Updated Account Details");
        System.out.println("-----------------------");
        account.display();

        System.out.println();
        account.accountHolder = "Aaryan H. Pawar";
        System.out.println("Account holder name updated to: " + account.accountHolder);
        System.out.println("Account Number remains: " + account.accountNumber);
        System.out.println("Account Number is declared final and cannot be changed.");
    }
}

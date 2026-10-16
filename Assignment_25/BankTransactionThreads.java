class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited Rs." + amount
                + " | Balance: Rs." + balance);
    }

    synchronized void withdraw(double amount) {
        if (amount > balance) {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw Rs." + amount
                    + " | Insufficient balance: Rs." + balance);
            return;
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdrew Rs." + amount
                + " | Balance: Rs." + balance);
    }

    synchronized double getBalance() {
        return balance;
    }
}

class DepositThread extends Thread {
    private final BankAccount account;
    private final double[] amounts;

    DepositThread(BankAccount account, double[] amounts) {
        super("DepositThread");
        this.account = account;
        this.amounts = amounts;
    }

    @Override
    public void run() {
        for (double amount : amounts) {
            account.deposit(amount);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }
    }
}

class WithdrawThread extends Thread {
    private final BankAccount account;
    private final double[] amounts;

    WithdrawThread(BankAccount account, double[] amounts) {
        super("WithdrawThread");
        this.account = account;
        this.amounts = amounts;
    }

    @Override
    public void run() {
        for (double amount : amounts) {
            account.withdraw(amount);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }
    }
}

public class BankTransactionThreads {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(5000);
        System.out.println("Opening balance: Rs." + account.getBalance());

        DepositThread depositThread = new DepositThread(account, new double[] {1000, 2500, 1500, 500});
        WithdrawThread withdrawThread = new WithdrawThread(account, new double[] {2000, 4000, 3000, 6000});

        depositThread.start();
        withdrawThread.start();

        depositThread.join();
        withdrawThread.join();

        System.out.println("Closing balance: Rs." + account.getBalance());
    }
}

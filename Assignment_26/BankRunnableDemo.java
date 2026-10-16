class Account {
    private double balance;

    Account(double balance) {
        this.balance = balance;
    }

    synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " -> Deposited Rs." + amount
                + " | Balance: Rs." + balance);
    }

    synchronized void withdraw(double amount) {
        if (amount > balance) {
            System.out.println(Thread.currentThread().getName() + " -> Withdrawal of Rs." + amount
                    + " failed | Balance: Rs." + balance);
            return;
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " -> Withdrew Rs." + amount
                + " | Balance: Rs." + balance);
    }

    synchronized double getBalance() {
        return balance;
    }
}

class DepositTask implements Runnable {
    private final Account account;
    private final double[] amounts;

    DepositTask(Account account, double[] amounts) {
        this.account = account;
        this.amounts = amounts;
    }

    @Override
    public void run() {
        for (double amount : amounts) {
            account.deposit(amount);
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
                System.out.println("Deposit task interrupted");
            }
        }
    }
}

class WithdrawTask implements Runnable {
    private final Account account;
    private final double[] amounts;

    WithdrawTask(Account account, double[] amounts) {
        this.account = account;
        this.amounts = amounts;
    }

    @Override
    public void run() {
        for (double amount : amounts) {
            account.withdraw(amount);
            try {
                Thread.sleep(450);
            } catch (InterruptedException e) {
                System.out.println("Withdraw task interrupted");
            }
        }
    }
}

public class BankRunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(3000);
        System.out.println("Opening balance: Rs." + account.getBalance());

        Thread depositThread = new Thread(new DepositTask(account, new double[] {1200, 800, 2000}), "Depositor");
        Thread withdrawThread = new Thread(new WithdrawTask(account, new double[] {1500, 4000, 2500}), "Withdrawer");

        depositThread.start();
        withdrawThread.start();

        depositThread.join();
        withdrawThread.join();

        System.out.println("Final balance: Rs." + account.getBalance());
    }
}

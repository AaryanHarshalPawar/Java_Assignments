class MultiplicationTableTask implements Runnable {
    private final int number;

    MultiplicationTableTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }
    }
}

class CountdownTask implements Runnable {
    private final int from;

    CountdownTask(int from) {
        this.from = from;
    }

    @Override
    public void run() {
        for (int i = from; i >= 1; i--) {
            System.out.println(Thread.currentThread().getName() + ": Countdown " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }
    }
}

public class RunnableTasksDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread tableThread = new Thread(new MultiplicationTableTask(7), "TableTask");
        Thread countdownThread = new Thread(new CountdownTask(5), "CountdownTask");

        tableThread.start();
        countdownThread.start();

        tableThread.join();
        countdownThread.join();

        System.out.println("Both Runnable tasks completed");
    }
}

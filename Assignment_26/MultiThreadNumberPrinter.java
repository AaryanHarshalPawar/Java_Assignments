class NumberPrinter extends Thread {
    private final int start;
    private final int end;

    NumberPrinter(String name, int start, int end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println(getName() + " started, state: " + getState());
        for (int i = start; i <= end; i++) {
            System.out.println(getName() + " prints " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }
        System.out.println(getName() + " finished");
    }
}

public class MultiThreadNumberPrinter {
    public static void main(String[] args) throws InterruptedException {
        NumberPrinter t1 = new NumberPrinter("Thread-A", 1, 5);
        NumberPrinter t2 = new NumberPrinter("Thread-B", 11, 15);
        NumberPrinter t3 = new NumberPrinter("Thread-C", 21, 25);

        System.out.println("After creation  -> " + t1.getName() + ": " + t1.getState());

        t1.start();
        t2.start();
        t3.start();
        System.out.println("After start()   -> " + t1.getName() + ": " + t1.getState());

        Thread.sleep(100);
        System.out.println("While sleeping  -> " + t1.getName() + ": " + t1.getState());

        t1.join();
        t2.join();
        t3.join();

        System.out.println("After join()    -> " + t1.getName() + ": " + t1.getState());
        System.out.println("All threads have completed");
    }
}

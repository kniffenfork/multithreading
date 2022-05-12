package fibonacci;

import java.util.Arrays;

public class Fibonacci {
    public static long[] fib(int n) {
        long[] f = new long[n];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < n; ++i) {
            if (!Thread.currentThread().isInterrupted()) {
                f[i] = f[i - 1] + f[i - 2];
            } else {
                System.out.println("Поток прерван!");
                return null;
            }
        }
        return f;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("======================================");
        System.out.println("RUNNABLE В КОНСТРУКТОР");

        Thread myFirstThread = new Thread(() -> System.out.println("first fib: " + Arrays.toString(fib(10000))));
        Thread mySecondThread = new Thread(() -> System.out.println("second fib: " + Arrays.toString(fib(5))));

        myFirstThread.start();
        mySecondThread.start();

        myFirstThread.interrupt();

        myFirstThread.join();
        mySecondThread.join();

        System.out.println("======================================");
        System.out.println("НАСЛЕДОВАНИЕ ОТ Thread");

        FibThread firstFib = new FibThread(5);
        FibThread secFib = new FibThread(15);

        firstFib.start();
        secFib.start();

        System.out.println("главный поток завершен");
    }
}

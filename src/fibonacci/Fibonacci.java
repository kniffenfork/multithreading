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
        Thread myFirstThread = new Thread(() -> System.out.println("first fib: " + Arrays.toString(fib(15))));
        Thread mySecondThread = new Thread(() -> System.out.println("second fib: " + Arrays.toString(fib(5))));

        myFirstThread.start();

        myFirstThread.join();

        mySecondThread.start();
    }
}

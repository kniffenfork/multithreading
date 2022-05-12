package fibonacci;

import java.util.Arrays;

public class FibThread extends Thread {
    private final int fibNum;
    public FibThread(int fibNum) {
        this.fibNum = fibNum;
    }

    @Override
    public void run() {
        System.out.println(Arrays.toString(Fibonacci.fib(fibNum)));
    }
}

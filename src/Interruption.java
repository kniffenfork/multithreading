import java.util.concurrent.TimeUnit;

public class Interruption {
    public static void main(String []args) {
        Runnable task = () -> {
            while(!Thread.currentThread().isInterrupted()) {
                //Do some work
            }
            System.out.println("Finished");
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.interrupt();
    }
}

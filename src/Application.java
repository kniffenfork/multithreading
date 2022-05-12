public class Application {
    public static void main(String[] args) {
        Thread myNewThread = new Thread(() -> System.out.println("Hello from subthread!!!"));
        myNewThread.start();
        System.out.println("главный поток завершен");
    }
}

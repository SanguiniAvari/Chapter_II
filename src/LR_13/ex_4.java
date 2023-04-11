package LR_13;

public class ex_4 {
    public static int count = 1;

    public static void main(String[] args) throws InterruptedException {
        creatThread();
    }

    public static void creatThread() throws InterruptedException {

        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + count);
            count ++;
        });
        t.start();
        t.join();
        if (count <= 10) {
            creatThread();
        }
    }
}

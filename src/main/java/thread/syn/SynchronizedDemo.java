package thread.syn;

/**
 * synchronized方法
 * 在多线程环境下应谨慎使用静态变量
 */
public class SynchronizedDemo implements Runnable {
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynchronizedDemo());
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result: " + count);
    }

    @Override
    public void run() {
        plus();
    }

    public synchronized void plus() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    /* 这里修改成同步静态方法，可以避免并发问题
    public static synchronized void plus() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }
    */
}
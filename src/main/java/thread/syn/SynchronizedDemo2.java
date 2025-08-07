package thread.syn;

/**
 * synchronized方法
 * 在多线程环境下应谨慎使用静态变量
 */
public class SynchronizedDemo2 implements Runnable {
    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        // 变为同一个实例，也可以确保锁
        SynchronizedDemo2 synchronizedDemo2 = new SynchronizedDemo2();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(synchronizedDemo2);
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
        for (int i = 0; i < 100000; i++) {
            count++;
        }
    }

}
package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * demo1
 *
 * @author lwy
 * @date 2025/08/14 15:40
 **/
public class ThreadDemo01 {
    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            a.addAndGet(1000);
        }).start();

    }
}

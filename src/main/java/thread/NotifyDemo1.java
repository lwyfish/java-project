package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * notify
 *
 * @author lwy
 * @date 2025/10/29 19:51
 **/
public class NotifyDemo1 {
    public static void main(String[] args) throws InterruptedException {
        List<String> waitList = new ArrayList<>();
        List<String> notifyList = new ArrayList<>();


        Object lock = new Object();
        // 休眠100个线程
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
//                String name1 = Thread.currentThread().getName();
//                System.out.println("23" + name1);
                synchronized (lock) {
                    String name2 = Thread.currentThread().getName();
                    System.out.println("26" + name2);
                    waitList.add(name2);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    notifyList.add(name2);
                }
            }).start();
        }
        Thread.sleep(10000);
        // 100个线程唤醒
        for (int i = 0; i < 100; i++) {
            synchronized (lock) {
                lock.notify();
            }
        }

        System.out.println(waitList);
        System.out.println(notifyList);

    }
}

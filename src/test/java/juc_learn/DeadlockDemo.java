package juc_learn;

/**
 * 死锁
 *
 * @author lwy
 * @date 2026/01/25 17:17
 **/
public class DeadlockDemo {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: 获得 lock1");
                try {
                    Thread.sleep(100); // 模拟执行时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: 尝试获取 lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1: 获得 lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: 获得 lock2");
                try {
                    Thread.sleep(100); // 模拟执行时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: 尝试获取 lock1");
                synchronized (lock1) {
                    System.out.println("Thread 2: 获得 lock1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
package thread.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreExample2 {
    private static final Lock lock = new ReentrantLock();

    // 创建一个 Semaphore 实例，初始许可数量为 2
    private static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        test1();
        test2();

    }

    public static void test1() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("start");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("在sleep时被中断，中断状态: " + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("线程恢复中断状态: " + Thread.currentThread().isInterrupted());

                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        });
        thread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        // 场景1: 在 sleep() 时中断
        Thread sleepThread = new Thread(() -> {
            try {
                System.out.println("sleepThread 开始休眠");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("sleepThread 在休眠时被中断");
                Thread.currentThread().interrupt();
            }
        });
        // 场景3: 在 Semaphore.acquire() 时中断
        Thread semaphoreThread = new Thread(() -> {
            try {
                System.out.println("semaphoreThread 尝试获取信号量");
                semaphore.acquire();
            } catch (InterruptedException e) {
                System.out.println("semaphoreThread 在获取信号量时被中断");
                Thread.currentThread().interrupt();
            }
        });

        // 场景4: 在 Lock.lockInterruptibly() 时中断
        Thread lockThread = new Thread(() -> {
            try {
                System.out.println("lockThread 尝试获取锁");
                lock.lockInterruptibly(); // 可中断的锁获取
                try {
                    System.out.println("lockThread 获取到锁");
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                System.out.println("lockThread 在获取锁时被中断");
                Thread.currentThread().interrupt();
            }
        });

        // 启动所有线程
        sleepThread.start();
        semaphoreThread.start();
        lockThread.start();

        // 给线程一点时间进入阻塞状态
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 中断所有线程
        sleepThread.interrupt();
        semaphoreThread.interrupt();
        lockThread.interrupt();

        System.out.println("已中断所有线程");

    }

}    
package juc_learn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * countDownLatch
 *
 * @author lwy
 * @date 2026/01/25 17:48
 **/
public class test5 {
    public static void main(String[] args) throws InterruptedException {
//        new test5().testCountDownLatch();
//        new test5().testCyclicBarrier();
        new test5().testSemaphore();
    }

    /**
     * 等5人都走之后，班长锁门
     *
     * @throws InterruptedException
     */
    public void testCountDownLatch() throws InterruptedException {
        CountDownLatch myCountDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "::" + "start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myCountDownLatch.countDown();
            }).start();
        }
        myCountDownLatch.await();
        System.out.println("end");
    }


    /**
     * 测试CyclicBarrier循环屏障
     * 创建了容量为3的循环屏障，当有3个线程到达屏障时，会执行预设的任务
     * 在这个例子中，我们启动了6个线程，所以会分两批执行，每3个线程为一批
     */
    public void testCyclicBarrier() {
        // 创建一个CyclicBarrier实例，设置parties数量为3，当3个线程到达屏障时执行barrierAction
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("3个线程已全部到达屏障，执行预设任务 - end");
        });

        // 定义线程执行任务
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "::" + "开始执行任务");
                try {
                    Thread.sleep(1000); // 模拟任务执行时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    // 调用await()方法，等待其他线程到达屏障
                    System.out.println(Thread.currentThread().getName() + "::" + "等待其他线程...");
                    cyclicBarrier.await(); // 等待直到3个线程都调用了此方法
                    System.out.println(Thread.currentThread().getName() + "::" + "继续执行后续任务");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // 启动6个线程，它们会被分成2组，每组3个线程
        for (int i = 0; i < 6; i++) {
            new Thread(new MyRunnable()).start();
        }
    }

    public void testSemaphore() {
        // 创建一个Semaphore对象，允许最多3个线程同时访问资源
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    // 获取一个许可，如果当前没有可用许可，则阻塞等待
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "::" + "获取信号量");
                    // 模拟业务处理时间
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "::" + "---释放信号量");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放一个许可，允许其他线程获取
                    semaphore.release();
                }
            }).start();
        }
    }
}

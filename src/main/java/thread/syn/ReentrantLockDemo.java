package thread.syn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock
 *
 * @author lwy
 * @date 2025/08/07 15:14
 **/
public class ReentrantLockDemo {
    public static void main(String[] args) {
        // 设置执行次数
        int executeCount = 2;
        // 定义方法开始时间，单位: ms
        long startTime = System.currentTimeMillis();
        // java.util.concurrent提供的API，在该案例中主要是为了让主线程等待子线程结束后进行打印
        CountDownLatch countDownLatch = new CountDownLatch(executeCount);

        ReentrantLock lock = new ReentrantLock();
        for (int index = 0; index < executeCount; index++) {
            new Thread(() -> {
                System.out.println(String.format("current thread name: %s start.", Thread.currentThread().getName()));

                // 加锁
                lock.lock();
                try {
                    // 休眠1秒
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 一定要在finally解锁
                    lock.unlock();
                }

                /// 休眠1秒，如果测试不加锁耗时可将注释打开并对上面加锁逻辑进行注释
                // sleep(1);
                System.out.println(String.format("current thread name: %s end.", Thread.currentThread().getName()));
                countDownLatch.countDown();
            }).start();
        }

        try {
            // 主线程等待子线程结束后打印log信息
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(String.format("cost time: %s ms", System.currentTimeMillis() - startTime));
    }
}

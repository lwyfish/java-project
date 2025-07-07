package thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 一等多：班长等待 5 个人写完作业，再关门
 * 首先创建了一个 CountDownLatch 对象，其计数器初始值为 5，表示需要等待 5 个同学完成作业。
 * 通过 for 循环创建 5 个线程来模拟 5 个同学写作业，每个线程在完成作业后调用 latch.countDown() 方法。
 * 班长线程调用 latch.await() 方法阻塞，直到计数器变为 0，此时所有同学都完成了作业，班长执行关门操作。
 */
public class CountDownLatchExample1 {
    public static void main(String[] args) throws InterruptedException {
        // 创建 CountDownLatch 对象，计数器初始值为 5
        CountDownLatch latch = new CountDownLatch(5);

        // 模拟 5 个同学写作业
        for (int i = 1; i <= 5; i++) {
            final int studentNumber = i;
            new Thread(() -> {
                System.out.println("同学 " + studentNumber + " 开始写作业");
                try {
                    // 模拟写作业耗时
                    Thread.sleep((long) (Math.random() * 3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("同学 " + studentNumber + " 写完作业");
                // 完成作业，计数器减 1
                latch.countDown();
            }).start();
        }

        // 班长等待所有同学写完作业
        System.out.println("班长等待同学们写完作业");
        latch.await();
        System.out.println("所有同学写完作业，班长关门");
    }

}
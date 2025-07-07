package thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 多等一：5 个短跑运动员等待裁判喊开始
 * 创建一个 CountDownLatch 对象，计数器初始值为 1，表示需要等待裁判发出开始信号。
 * 通过 for 循环创建 5 个线程来模拟 5 个运动员，每个运动员线程调用 latch.await() 方法阻塞，等待裁判的开始信号。
 * 主线程模拟裁判的准备过程，2 秒后裁判发出开始信号，调用 latch.countDown() 方法使计数器变为 0，此时所有运动员线程继续执行，开始跑步。
 */
public class CountDownLatchExample2 {
    public static void main(String[] args) throws InterruptedException {
        // 创建 CountDownLatch 对象，计数器初始值为 1
        CountDownLatch latch = new CountDownLatch(1);

        // 模拟 5 个运动员等待
        for (int i = 1; i <= 5; i++) {
            final int athleteNumber = i;
            new Thread(() -> {
                System.out.println("运动员 " + athleteNumber + " 准备就绪，等待裁判开始信号");
                try {
                    // 等待裁判开始信号
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("运动员 " + athleteNumber + " 开始跑步");
            }).start();
        }

        // 模拟裁判准备和发出开始信号
        Thread.sleep(2000);
        System.out.println("裁判喊：开始！");
        // 裁判发出开始信号，计数器减 1
        latch.countDown();
    }
}